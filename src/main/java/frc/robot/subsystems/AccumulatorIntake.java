package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;



public class AccumulatorIntake extends SubsystemBase{

    TalonSRX intakeMotor = new TalonSRX(Constants.CAN_TALON_INTAKE_MOTOR);
    

    public AccumulatorIntake(){
    }
  
    public void runIntake(final double speed){
      intakeMotor.set(ControlMode.PercentOutput, -speed);
    }
  
    public void stop(){
      intakeMotor.set(ControlMode.PercentOutput, 0);
    }
  
   
  
}