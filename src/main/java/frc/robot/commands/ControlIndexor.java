package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexor;
import edu.wpi.first.wpilibj.Timer;

public class ControlIndexor extends CommandBase{
    private final Indexor mIndexor;
    private final double time;
    Timer timer;

    public ControlIndexor(Indexor _Indexor, double _time){
        mIndexor = _Indexor;
        time = _time;
        timer = new Timer();
    
    }

    @Override
    public void initialize(){
        timer.reset();
        timer.start();
    }

    @Override
    public void execute(){
        mIndexor.dumpBalls();
    }

    @Override
    public boolean isFinished() {
        if(timer.get() > time){
            mIndexor.stop();
            return true;
        }
        return false;
    }
}
