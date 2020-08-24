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

public class Drivetrain extends SubsystemBase{
    CANSparkMax lfMotor = new CANSparkMax(ConfigMap.CAN_LF_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax lmMotor = new CANSparkMax(ConfigMap.CAN_LM_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax lbMotor = new CANSparkMax(ConfigMap.CAN_LB_DRIVE_MOTOR, MotorType.kBrushless);
    
    CANSparkMax rfMotor = new CANSparkMax(ConfigMap.CAN_RF_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax rmMotor = new CANSparkMax(ConfigMap.CAN_RM_DRIVE_MOTOR, MotorType.kBrushless);
    CANSparkMax rbMotor = new CANSparkMax(ConfigMap.CAN_RB_DRIVE_MOTOR, MotorType.kBrushless);
}