package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Lift;
import frc.robot.subsystems.LEDs;

public class LiftBrakeOn extends CommandBase {
    private final Lift mLift;
    private final LEDs mLEDs;

    public LiftBrakeOn(Lift _Lift, LEDs _LEDs){
        mLift = _Lift;
        mLEDs = _LEDs;
        addRequirements(mLift);
    }

    @Override
    public void initialize(){
        mLift.brakeOn();
        mLEDs.setColor(mLEDs.RED);
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}