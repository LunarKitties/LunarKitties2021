package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lift;

public class OperateLift extends CommandBase{
    private final Lift mLift;
    private final DoubleSupplier mLeftStickY;
    private final DoubleSupplier mLeftStickX;

    public OperateLift(Lift subsystem, DoubleSupplier leftStickY, DoubleSupplier leftStickX){
        mLift = subsystem;
        mLeftStickY = leftStickY;
        mLeftStickX = leftStickX;
        addRequirements(mLift);
    }

    @Override
    public void execute(){
        //the speed of raising the lift will be controlled by the Y-component of the left stick
        double liftSpeed = mLeftStickY.getAsDouble();
        //the speed of the skywalker will be controlled by the X-component of the left stick
        double skySpeed = mLeftStickX.getAsDouble();

        mLift.walkSky(skySpeed);
        mLift.runLift(liftSpeed);
    }
}