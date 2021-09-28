package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import java.util.function.DoubleSupplier;

public class DriveWithController extends CommandBase{
    private final Drivetrain mDrivetrain;
    private final DoubleSupplier mLeftTrigger;
    private final DoubleSupplier mRightTrigger;
    private final DoubleSupplier mRightStickX;

    public DriveWithController(Drivetrain subsystem, DoubleSupplier leftTrigger, DoubleSupplier rightTrigger, DoubleSupplier rightStickX){
        mDrivetrain = subsystem;
        mLeftTrigger = leftTrigger;
        mRightTrigger = rightTrigger;
        mRightStickX = rightStickX;
        addRequirements(mDrivetrain);
    }

    @Override
    public void execute(){
        //Speed is based on the triggers. Left Trigger is reverse, Right Trigger is forward
        double speed = -mRightTrigger.getAsDouble() + mLeftTrigger.getAsDouble();

        //To Rotate you use the Right Joystick X Axis
        double rotate = -mRightStickX.getAsDouble();

        //Drive the Robot
        mDrivetrain.drive(-speed,rotate);
    }
    
}