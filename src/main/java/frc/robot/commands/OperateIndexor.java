package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexor;
import frc.robot.subsystems.LEDs;

import java.util.function.BooleanSupplier;

public class OperateIndexor extends CommandBase{
    private final Indexor mIndexor;
    private final LEDs mLEDs;
    private final BooleanSupplier mAButton;
    private final BooleanSupplier mBButton;

    double currEncDist, targetEncDist;
    static double spacedEncDist = 3500;
    int ballCount;
    boolean currBall = false;
    boolean moveBall = false; 

    public OperateIndexor(Indexor subsystem, LEDs _LEDs, BooleanSupplier aButton, BooleanSupplier bButton){
        mIndexor = subsystem;
        mLEDs = _LEDs;
        mAButton = aButton;
        mBButton = bButton;
        addRequirements(mIndexor);
    }

    @Override
    public void execute(){
        //boolean ballHere = mIndexor.ballHere();
        boolean colorSeesBall = mIndexor.colorSeesBall();
        /*
        currEncDist = Math.abs(mIndexor.getEncoder());
        if (currBall && !colorSeesBall){
            targetEncDist = currEncDist + spacedEncDist;
            moveBall = true;
            currBall = false;
        }
        if(moveBall){
          if(currEncDist < targetEncDist){
            //run the intake belts
            mIndexor.runBelts(-0.8);
          }else{
            moveBall = false;
          }
        }else{
          mIndexor.stop();
        }
        */
        if(mAButton.getAsBoolean()){
          mIndexor.dumpBalls();
        }else if(mBButton.getAsBoolean()){
          mIndexor.unShoot();
        } else {
          mIndexor.stop();
        }
        if(colorSeesBall){
          mLEDs.setColor(mLEDs.GOLD_PATTERN);
        } else {
          mLEDs.setColor(mLEDs.RAINBOW);
        }

        mIndexor.log();
    }
}
