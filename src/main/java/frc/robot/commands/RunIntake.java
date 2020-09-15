package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AccumulatorIntake;

public class RunIntake extends CommandBase {
    private final DoubleSupplier mrTrig2;
    private final DoubleSupplier mlTrig2;
    private final AccumulatorIntake mAccumulatorIntake;


    public RunIntake (AccumulatorIntake Subsystem, DoubleSupplier rTrig2, DoubleSupplier lTrig2)
    {
        mrTrig2 = rTrig2;
        mlTrig2 = lTrig2;
        mAccumulatorIntake = Subsystem;
        addRequirements(mAccumulatorIntake);
    }
    @Override
    public void execute() {
        double posSpeed, negSpeed;
    //Speed is based on the triggers. Left Trigger is reverse, Right Trigger is forward
        posSpeed = mrTrig2.getAsDouble();
        negSpeed = -mlTrig2.getAsDouble();

        if(mrTrig2.getAsDouble() > mlTrig2.getAsDouble())
        {
            mAccumulatorIntake.runIntake(posSpeed);
        }
        else
        {
            mAccumulatorIntake.runIntake(negSpeed);
        }
      
    }  

}