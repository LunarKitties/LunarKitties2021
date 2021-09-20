package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Timer;

public class SimpleAuto extends CommandBase{
    private final Drivetrain mDrivetrain;
    Timer m_timer = new Timer();

    public SimpleAuto(Drivetrain _Drivetrain){
        mDrivetrain = _Drivetrain;
    }

    @Override
    public void initialize(){
        m_timer.reset();
        m_timer.start();
    }

    @Override
    public void execute(){

        if(m_timer.get() < 1.0){
            mDrivetrain.drive(-.2,0);
        }else{
            mDrivetrain.stop();
            end(true);
        }
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
    
}