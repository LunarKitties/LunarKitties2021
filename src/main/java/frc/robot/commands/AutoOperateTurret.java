package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.NavX;

public class AutoOperateTurret extends CommandBase {
  //Main control vars
    public static int maxCWPos = 236;
    public static int maxCCWPos = -270;
    public static int goalCWPos = 220;
    public static int goalCCWPos = -220;
    public static double minSpeed = 0.06;
    public static double kPGoal = 0.035;
    public static double kPEnc = 0.005;
    double currErr, goalEnc, currAngle, speed;
    boolean targetFound;
    private final Turret mTurret;
    private final Limelight mLimelight;
    private final NavX mNavX;

    public AutoOperateTurret(Turret _Turret, Limelight _Limelight, NavX _NavX) {
      mTurret = _Turret;
      mLimelight = _Limelight;
      mNavX = _NavX;
      addRequirements(mTurret);
    }

    @Override
  public void execute(){
    targetFound = mLimelight.targetAcquired();
    if(targetFound && mNavX.getAngle() < 55 && mNavX.getAngle() > -55){
      //use limelight
      currErr = mLimelight.crosshairX();
      if (currErr > 0.5){
        speed = -kPGoal*currErr - minSpeed;
      }else if (currErr < -0.5){
        speed = -kPGoal*currErr + minSpeed;
      }
      if(mTurret.currEncode() >= goalCWPos && speed > 0){
        speed = 0;
      }else if (mTurret.currEncode() <= goalCCWPos && speed < 0){
        speed = 0;          }
    }else{
      currErr = mTurret.currEncode();
      if(currErr > 3){
        speed = kPEnc * currErr + minSpeed;
      }else if(currErr < -3){
        speed = kPEnc * currErr - minSpeed;
      }else{
        speed = 0;
      }
    }

    mTurret.run(speed);
    mTurret.log(speed);
  }
}