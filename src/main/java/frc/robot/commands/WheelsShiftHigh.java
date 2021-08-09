package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class WheelsShiftHigh extends CommandBase {
    private final Drivetrain mDrivetrain;

    public WheelsShiftHigh(Drivetrain subsystem){
        mDrivetrain = subsystem;
        addRequirements(mDrivetrain);
    }

    @Override
    public void initialize(){
        mDrivetrain.shiftHigh();
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}