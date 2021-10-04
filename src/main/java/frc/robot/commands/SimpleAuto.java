package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;

import frc.robot.commands.ControlLauncher;

import frc.robot.subsystems.Turret;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Indexor;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.NavX;
import frc.robot.subsystems.Shooter;

public class SimpleAuto extends CommandGroupBase{

    private final Drivetrain mDrivetrain;
    private final Shooter mShooter;
    private final Turret mTurret;
    private final Indexor mIndexor;
    private final Limelight mLimelight;
    private final NavX mNavX;

    public SimpleAuto(Drivetrain _Drivetrain, Turret _Turret, Shooter _Shooter, Indexor _Indexor, Limelight _Limelight, NavX _NavX){
        mDrivetrain = _Drivetrain;
        mTurret = _Turret;
        mShooter = _Shooter;
        mIndexor = _Indexor;
        mLimelight = _Limelight;
        mNavX = _NavX;
    }
    
    @Override
    public void addCommands(Command... commands) {
        sequence(
                new ControlLauncher(mTurret, mShooter, 100)
            );
    }
}