package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LEDs;

public class WheelsShiftLow extends CommandBase {
    private final Drivetrain mDrivetrain;
    private final LEDs mLEDs;

    public WheelsShiftLow(Drivetrain _Drivetrain, LEDs _LEDs){
        mDrivetrain = _Drivetrain;
        mLEDs = _LEDs;
        addRequirements(mDrivetrain);
    }

    @Override
    public void initialize(){
        mDrivetrain.shiftLow();
        mLEDs.setColor(mLEDs.WAVES_FOREST);
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}