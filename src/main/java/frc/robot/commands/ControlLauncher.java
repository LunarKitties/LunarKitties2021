package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Turret;
import frc.robot.subsystems.Shooter;

public class ControlLauncher extends CommandBase {
    private final Turret mTurret;
    private final Shooter mShooter;
    private final int turretEnc;

    int encRange = 30;
    double speed = 0.5;
    boolean done = false;

    public ControlLauncher(Turret _Turret, Shooter _Shooter, int _turretEnc) {
      mTurret = _Turret;
      mShooter = _Shooter;
      turretEnc = _turretEnc;
      //shooterSpeed = _shooterSpeed;
    }

    @Override
  public void execute(){
    if(turretEnc > (mTurret.currEncode() + encRange)){
      mTurret.run(speed);
    }else if (turretEnc > (mTurret.currEncode() + encRange)){
      mTurret.run(speed);
    }else{
      mTurret.run(speed);
      done = true;
    }
    mShooter.setSpeed(-4200);
  }

  @Override
  public boolean isFinished(){
    return done;
  }
}