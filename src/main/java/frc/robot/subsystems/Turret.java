package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Turret extends SubsystemBase{
    TalonSRX turretMotor = new TalonSRX(Constants.CAN_TALON_TURRET_MOTOR);

    Encoder turretEnc = new Encoder(Constants.DIO_TURRET_A_ENCODER, Constants.DIO_TURRET_B_ENCODER);
      
    //constructor
  public Turret()
  {

  }

  public int currEncode(){
    return turretEnc.get();
  }

  public void resetEncoder(){
    turretEnc.reset();
  }

  public void run(double speed){
    turretMotor.set(ControlMode.PercentOutput, speed);
  }
  public void turn(){
    turretMotor.set(ControlMode.PercentOutput, .5);
  }

  public void stop(){
    turretMotor.set(ControlMode.PercentOutput, 0);
  }

  public void log(){
    SmartDashboard.putNumber("Turret Encoder", currEncode());
    SmartDashboard.putNumber("Turret Motor Power", turretMotor.getMotorOutputPercent());
  }
}
