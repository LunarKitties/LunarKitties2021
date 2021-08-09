package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;



import frc.robot.Constants;

public class Lift extends SubsystemBase{
        
        //Motor Controller Objects based on CAN IDs
    TalonSRX skywalker = new TalonSRX(Constants.CAN_TALON_SKYWALKER_MOTOR);
    VictorSPX liftMotor = new VictorSPX(Constants.CAN_VICTOR_LIFT_MOTOR);

        //Solenoid object based on the port the solenoid is located in the PCM (Pneumatics Control Module)
    DoubleSolenoid brake = new DoubleSolenoid(Constants.PCM_BRAKE_IN, Constants.PCM_BRAKE_OUT);

        //constructor
    public Lift(){
        
    }

    public void runLift(double speed){
        liftMotor.set(ControlMode.PercentOutput, speed);
    }

    public void walkSky(double speed){
        skywalker.set(ControlMode.PercentOutput, speed);
    }

    public void brakeOn(){
        brake.set(Value.kForward);
    }

    public void brakeOff(){
        brake.set(Value.kReverse);
    }

    public boolean brakeEngaged(){
        return brake.get() == Value.kForward;
    }

   public void stop(){
       liftMotor.set(ControlMode.PercentOutput, 0);
   }

   public void log(){
       //SmartDashboard.putNumber("Lift Balance", PUT.GRYO.CODE.HERE)
   }
}