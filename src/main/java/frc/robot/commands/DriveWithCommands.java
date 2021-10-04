package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveWithCommands extends CommandBase{
    private final Drivetrain mDrivetrain;
    private final double speed;
    private final double rotate;
    private final double time;
    Timer timer;
    boolean done = false;

    public DriveWithCommands(Drivetrain _Drivetrain, double _speed, double _rotate, double _time){
        mDrivetrain = _Drivetrain;
        speed = _speed;
        rotate = _rotate;        
        time = _time; //in seconds
        timer.start();
    }

    @Override
    public void execute(){
        //Drive the Robot
        mDrivetrain.drive(speed,rotate);
        if(time > timer.get()){
            done = true;
        }
    }

    @Override
    public boolean isFinished() {
        return done;
    }
    
}