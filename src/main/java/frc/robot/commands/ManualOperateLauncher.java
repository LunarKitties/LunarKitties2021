package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Turret;
import frc.robot.subsystems.Shooter;
import java.util.function.DoubleSupplier;

public class ManualOperateLauncher extends CommandBase {
    private final Turret mTurret;
    private final Shooter mShooter;

    private final DoubleSupplier rightStickX2;
    private final DoubleSupplier mdpad;

    double speed;

    public ManualOperateLauncher(Turret _Turret, Shooter _Shooter, DoubleSupplier _rightStickX2, DoubleSupplier _dpad) {
      mTurret = _Turret;
      mShooter = _Shooter;
      rightStickX2 = _rightStickX2;
      mdpad = _dpad;
    }

    @Override
  public void execute(){
    speed = -rightStickX2.getAsDouble();
    if (speed > 0.7){
      speed = 0.7;
    }else if (speed < -0.7){
      speed = -0.7;
    }
    mTurret.run(speed);

    if (mdpad.getAsDouble() < 0){ //DPAD UP
      //do nothing
    }else if (mdpad.getAsDouble() < 45.0 || mdpad.getAsDouble() > 315){ //DPAD UP
      mShooter.setSpeed(-5000);
    } else if (mdpad.getAsDouble() < 135.0 && mdpad.getAsDouble() > 45){//DPAD Right
      mShooter.setSpeed(-4200);
    } else if (mdpad.getAsDouble() < 240.0 && mdpad.getAsDouble() > 135){//DPAD DOWN
      mShooter.stop();
    } else if (mdpad.getAsDouble() < 315.0 && mdpad.getAsDouble() > 245){//DPAD Left
      mShooter.setSpeed(-3675);
    }

    mTurret.log(speed);
  }
}