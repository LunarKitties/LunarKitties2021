package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class ShiftLow extends CommandBase {
    private final Drivetrain mDrivetrain;

    public ShiftLow(Drivetrain subsystem){
        mDrivetrain = subsystem;
        addRequirements(mDrivetrain);
    }

    @Override
    public void initialize(){
        mDrivetrain.shiftLow();
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}