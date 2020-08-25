package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.GenericHID;

public class DriveWithController extends CommandBase{
    private final Drivetrain mDrivetrain;

    public DriveWithController(Drivetrain subsystem){
        mDrivetrain = subsystem;
        addRequirements(mDrivetrain);
    }

    @Override
    public void execute(){
        //Get Controller 1
        XboxController xbox = Robot.m_oi.getXboxController1();

        //Speed is based on the triggers. Left Trigger is reverse, Right Trigger is forward
        double lt = xbox.getTriggerAxis(Hand.kLeft);
        double rt = xbox.getTriggerAxis(Hand.kRight);
        double speed = rt - lt;

        //To Rotate you use the Right Joystick X Axis
        double rotate = xbox.getX(Hand.kRight);

        //Drive the Robot
        mDrivetrain.drive(-speed,rotate);
    }
    
}