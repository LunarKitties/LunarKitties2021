package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Lift;
import frc.robot.subsystems.LEDs;

public class LiftBrakeOff extends CommandBase {
    private final Lift mLift;
    private final LEDs mLEDs;

    public LiftBrakeOff(Lift _Lift, LEDs _LEDs){
        mLift = _Lift;
        mLEDs = _LEDs;
        addRequirements(mLift);
    }

    @Override
    public void initialize(){
        mLift.brakeOff();
        mLEDs.setColor(mLEDs.RAINBOW);
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}