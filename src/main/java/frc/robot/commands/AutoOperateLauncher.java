package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;
import frc.robot.subsystems.NavX;
import frc.robot.subsystems.Limelight;
import java.util.function.BooleanSupplier;

public class AutoOperateLauncher extends CommandBase {
  private final Shooter mShooter;
  private final Turret mTurret;
  private final NavX mNavX;
  private final Limelight mLimelight;
  private final BooleanSupplier onShooter;
  private final BooleanSupplier offShooter;
  private final BooleanSupplier rightStickX2;
  
    //turret control
  public static int maxCWPos = 236;
  public static int maxCCWPos = -270;
  public static int goalCWPos = 220;
  public static int goalCCWPos = -220;
  public static double minSpeed = 0.06;
  public static double kPGoal = 0.035;
  public static double kPEnc = 0.005;
  double currErr, goalEnc, currAngle, speed;
  boolean targetFound;
    //shooter control
  private boolean shooterRunning = false;
  private double spdFromDist;

  public AutoOperateLauncher(Shooter _Shooter, Turret _Turret, NavX _NavX, Limelight _Limelight, BooleanSupplier _onShooter, BooleanSupplier _offShooter, BooleanSupplier _RightStickX2){
    mShooter = _Shooter;
    mTurret = _Turret;
    mNavX = _NavX;
    mLimelight = _Limelight;
    onShooter = _onShooter;
    offShooter = _offShooter;
    rightStickX2 = _RightStickX2;
  }

  // Called repeatedly when this Command is scheduled to run
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

    spdFromDist = mShooter.getSpeed(mLimelight);
    if(shooterRunning){
      mShooter.setSpeed(spdFromDist);
    }else{
      mShooter.stop();
    }

    if(onShooter.getAsBoolean()){
      shooterRunning = true;
    }
    if(offShooter.getAsBoolean()){
      shooterRunning = false;
    }

    mTurret.run(speed);
    mTurret.log(speed);
    mShooter.log();
  }

  @Override
  public boolean isFinished(){
    return rightStickX2.getAsBoolean();
  }
}