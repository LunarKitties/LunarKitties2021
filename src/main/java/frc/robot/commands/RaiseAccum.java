package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AccumulatorJoint;
import frc.robot.Constants;

public class RaiseAccum extends CommandBase {
    private final AccumulatorJoint mAccumulatorJoint;

    public RaiseAccum(AccumulatorJoint Subsystem)
    {
        mAccumulatorJoint = Subsystem;
        addRequirements(mAccumulatorJoint);
    }

   
    // Called repeatedly when this Command is scheduled to run
     
    @Override
    public void execute() {
      double speed;
  
      if(mAccumulatorJoint.accumEncoder() < Constants.AccumUp){
        speed = -0.8;
      }else{
        speed = 0;
      }
      mAccumulatorJoint.adjustAccum(speed);
    }

    public boolean isFinished() 
    {
        if(mAccumulatorJoint.accumEncoder() >= Constants.AccumUp){
            return true;
        }
        else{
            return false;
        }
    }

    
}