package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LEDs;

public class WheelsShiftHigh extends CommandBase {
    private final Drivetrain mDrivetrain;
    private final LEDs mLEDs;

    public WheelsShiftHigh(Drivetrain _Drivetrain, LEDs _LEDs){
        mDrivetrain = _Drivetrain;
        mLEDs = _LEDs;
        addRequirements(mDrivetrain);
    }

    @Override
    public void initialize(){
        mDrivetrain.shiftHigh();
        mLEDs.setColor(mLEDs.RAINBOW);
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}