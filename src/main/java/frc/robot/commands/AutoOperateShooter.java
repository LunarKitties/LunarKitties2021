package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Limelight;
import java.util.function.BooleanSupplier;

public class AutoOperateShooter extends CommandBase {
  private final Shooter mShooter;
  private final Limelight mLimelight;
  private final BooleanSupplier toggleShooter;

  private boolean shooterRunning = false;
  private boolean buttonHeld = false;
  private double spdFromDist;

  public AutoOperateShooter(Shooter _Shooter, Limelight _Limelight, BooleanSupplier _toggleShooter){
    mShooter = _Shooter;
    mLimelight = _Limelight;
    toggleShooter = _toggleShooter;
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

    //Needs logic for toggling shooter motors off/on (using shoorterRunning bool)
  }
}