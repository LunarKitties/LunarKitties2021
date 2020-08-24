package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.controller.PIDController;

import frc.robot.Constants;

public class Drivetrain extends SubsystemBase{
    CANSparkMax lfMotor = new CANSparkMax(Constants.CAN_LF_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax lmMotor = new CANSparkMax(Constants.CAN_LM_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax lbMotor = new CANSparkMax(Constants.CAN_LB_DRIVE_MOTOR, MotorType.kBrushless);
    
    CANSparkMax rfMotor = new CANSparkMax(Constants.CAN_RF_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax rmMotor = new CANSparkMax(Constants.CAN_RM_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax rbMotor = new CANSparkMax(Constants.CAN_RB_DRIVE_MOTOR, MotorType.kBrushless);
}