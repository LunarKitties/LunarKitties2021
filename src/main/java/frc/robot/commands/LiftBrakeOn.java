package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Lift;

public class LiftBrakeOn extends CommandBase {
    private final Lift mLift;

    public LiftBrakeOn(Lift subsystem){
        mLift = subsystem;
        addRequirements(mLift);
    }

    @Override
    public void initialize(){
        mLift.brakeOn();
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}