package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.controller.PIDController;

import frc.robot.Constants;

public class Drivetrain extends SubsystemBase{
        
        //Motor Controller Objects based on CAN IDs
    CANSparkMax lfMotor = new CANSparkMax(Constants.CAN_LF_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax lmMotor = new CANSparkMax(Constants.CAN_LM_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax lbMotor = new CANSparkMax(Constants.CAN_LB_DRIVE_MOTOR, MotorType.kBrushless);
    
    CANSparkMax rfMotor = new CANSparkMax(Constants.CAN_RF_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax rmMotor = new CANSparkMax(Constants.CAN_RM_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax rbMotor = new CANSparkMax(Constants.CAN_RB_DRIVE_MOTOR, MotorType.kBrushless);

        //Group the Left and Right Motors together
    public SpeedControllerGroup leftWheels = new SpeedControllerGroup(lfMotor, lmMotor, lbMotor);
    public SpeedControllerGroup rightWheels = new SpeedControllerGroup(rfMotor, rmMotor, rbMotor);

        //Create Differential Drive Object allowing us to drive the robot
    DifferentialDrive dd = new DifferentialDrive(leftWheels, rightWheels);

      //Wheel Shifters
    DoubleSolenoid shifters = new DoubleSolenoid(Constants.PCM_DRIVE_S_IN, Constants.PCM_DRIVE_S_OUT);

        //constructor
    public Drivetrain(){
        dd.setSafetyEnabled(false);
    }

    public void drive(double speed, double rotate){
        dd.arcadeDrive(speed, rotate);
    }

    public void shiftHigh(){
        shifters.set(Value.kForward);
    }

    public void shiftLow(){
        shifters.set(Value.kReverse);
    }

    public void stop(){
        dd.stopMotor();
    }

    public boolean isHighGear(){
        return shifters.get() == Value.kForward;
    }

    public boolean isLowGear(){
        return shifters.get() == Value.kReverse;
    }
}