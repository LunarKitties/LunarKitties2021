package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

import frc.robot.subsystems.Shooter;
import java.util.function.DoubleSupplier;

public class OperateShooter extends CommandBase {
  private final Shooter mShooter;
  private final DoubleSupplier mdpad;

  public OperateShooter(Shooter subsystem, DoubleSupplier dpad){
    mShooter = subsystem;
    mdpad = dpad;
    addRequirements(mShooter);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute(){
    //double spdFromDist = Robot.mShooter.getSpeed();
    
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
  }
}