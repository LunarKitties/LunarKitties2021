package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Limelight;
import java.util.function.BooleanSupplier;

public class AutoOperateShooter extends CommandBase {
  private final Shooter mShooter;
  private final Limelight mLimelight;
  private final BooleanSupplier onShooter;
  private final BooleanSupplier offShooter;

  private boolean shooterRunning = false;
  private double spdFromDist;

  public AutoOperateShooter(Shooter _Shooter, Limelight _Limelight, BooleanSupplier _onShooter, BooleanSupplier _offShooter){
    mShooter = _Shooter;
    mLimelight = _Limelight;
    onShooter = _onShooter;
    offShooter = _offShooter;
    addRequirements(mShooter);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute(){
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
  }
}