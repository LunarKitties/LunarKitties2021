package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.Turret;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Indexor;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.NavX;
import frc.robot.subsystems.Shooter;

public class SimpleAuto extends SequentialCommandGroup{

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

        addCommands(
            new DriveWithCommands(mDrivetrain, 0.5, 0, 3),
            new ControlLauncher(mTurret, mShooter, 100)
        );
    }
}