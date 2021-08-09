package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class AccumulatorJoint extends SubsystemBase{

    VictorSPX adjustMotor = new VictorSPX(Constants.CAN_VICTOR_ADJUST_MOTOR);
    
    Encoder accumEnc = new Encoder(Constants.DIO_ACCUM_A_ENCODER, Constants.DIO_ACCUM_B_ENCODER);

    public AccumulatorJoint()
    {
        //Liz and Ethan are fun humans
    }

  
    public void adjustAccum(final double speed) {
      adjustMotor.set(ControlMode.PercentOutput, speed);
    }
  
   
    public void resetEncoder(){
      accumEnc.reset();
    }
    public int accumEncoder(){
          return accumEnc.get();
    }
  
    public void stop(){
      adjustMotor.set(ControlMode.PercentOutput, 0);
    }
  
    public void log(){
      SmartDashboard.putNumber("Accum Raising Encoder", accumEncoder());
    }
  
}
