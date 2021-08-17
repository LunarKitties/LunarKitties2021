package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;

import com.revrobotics.ColorSensorV3;

/**
 * Configuration and basic commands for the shooter.
 */
public class Indexor extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Create Motor Controller Objects based on CAN IDs
    TalonSRX indexMotor = new TalonSRX(Constants.CAN_TALON_INDEX_MOTOR);
    TalonSRX preShootMotor = new TalonSRX(Constants.CAN_TALON_PRE_SHOOT_MOTOR);
    Encoder indexEnc = new Encoder(Constants.DIO_INDEX_A_ENCODER, Constants.DIO_INDEX_B_ENCODER);

        //Replaced touch sensors with color sensor. Left code for future referencing. 
    //private final DigitalInput ballReadyRight = new DigitalInput(Constants.DIO_INDEX_RIGHT_BALL_SWITCH);
    //private final DigitalInput ballReadyLeft = new DigitalInput(Constants.DIO_INDEX_LEFT_BALL_SWITCH);

    private final I2C.Port i2cPort = I2C.Port.kOnboard;

    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    
  public Indexor()
  {
  }
  
  /*
  public boolean ballHere(){
    return ballReadyRight.get() || ballReadyLeft.get();
  }
  */

  public void runBelts(double speed){
    indexMotor.set(ControlMode.PercentOutput, speed);
  }

  public int indexEncoder(){
    return indexEnc.get();
  }

  public void runPreShoot(double speed){
    preShootMotor.set(ControlMode.PercentOutput, speed);
  }

  public void dumpBalls(){
    runPreShoot(1);
    runBelts(-0.8);
  }

  public void unShoot(){
    runPreShoot(-1);
    runBelts(0.8);
  }

  public int getRed(){
    return m_colorSensor.getRed();
  }

  public int getBlue(){
    return m_colorSensor.getBlue();
  }

  public int getGreen(){
    return m_colorSensor.getGreen();
  }

  public boolean colorSeesBall(){
    int red = getRed();
    int blue = getBlue();
    int green = getGreen();
    boolean redInRange = false;
    boolean blueInRange = false;
    boolean greenInRange = false;
    
    if(red < 20){
      redInRange = true;
    }
    if(blue < 20){
      blueInRange = true;
    }
    if(green < 20){
      greenInRange = true;
    }
    return redInRange && blueInRange && greenInRange;
  }

  public void stop(){
    indexMotor.set(ControlMode.PercentOutput, 0);
    preShootMotor.set(ControlMode.PercentOutput, 0);
  }

  public void log(){
    SmartDashboard.putNumber("Index Encoder", indexEncoder());
    //SmartDashboard.putBoolean("Index Ball Switch", ballHere());
    SmartDashboard.putNumber("Red", getRed());
    SmartDashboard.putNumber("Blue", getBlue());
    SmartDashboard.putNumber("Green", getGreen());
  }


}