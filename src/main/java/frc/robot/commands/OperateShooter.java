package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class OperateShooter extends CommandBase {
  private final Shooter mShooter;

  public OperateShooter(Shooter subsystem) {
    mShooter = subsystem;
    addRequirement(mShooter);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    XboxController xbox = Robot.m_oi.getXboxController2();
    int dPad = xbox.getPOV();

    double spdFromDist = Robot.mShooter.getSpeed();

    
    //DPAD UP
    if (dPad < 45 && dPad > 315){
      Robot.mShooter.setSpeed(-5000); 
    }
    //DPAD RIGHT
    if (dPad < 135 && dPad > 45){
      Robot.mShooter.setSpeed(-4200); 
    }
    //
    if (dPad < 240 && dPad > 135){
      Robot.mShooter.stop(); 
    }

    if (dPad < 315 && dPad > 245){
      Robot.mShooter.setSpeed(-3675); 
    }
    
  }  

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.mShooter.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}