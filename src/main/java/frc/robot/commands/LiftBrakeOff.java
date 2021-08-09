package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Lift;

public class LiftBrakeOff extends CommandBase {
    private final Lift mLift;

    public LiftBrakeOff(Lift subsystem){
        mLift = subsystem;
        addRequirements(mLift);
    }

    @Override
    public void initialize(){
        mLift.brakeOff();
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}