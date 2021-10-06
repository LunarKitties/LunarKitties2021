/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
//
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController.Button;

  //commands
import frc.robot.commands.DriveWithController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.LiftBrakeOff;
import frc.robot.commands.LiftBrakeOn;
import frc.robot.commands.LowerAccum;
import frc.robot.commands.ManualOperateLauncher;
import frc.robot.commands.OperateIndexor;
import frc.robot.commands.OperateLift;
import frc.robot.commands.AutoOperateLauncher;
import frc.robot.commands.RaiseAccum;
import frc.robot.commands.RunIntake;
import frc.robot.commands.WheelsShiftHigh;
import frc.robot.commands.WheelsShiftLow;
import frc.robot.commands.SimpleAuto;
  
  //subsystems
import frc.robot.subsystems.AccumulatorIntake;
import frc.robot.subsystems.AccumulatorJoint;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Indexor;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.NavX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.subsystems.LEDs;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final Drivetrain mDrivetrain = new Drivetrain();
  private final LEDs mLEDs = new LEDs();
  private final Lift mLift = new Lift();
  private final AccumulatorIntake mAccumulatorIntake = new AccumulatorIntake();
  private final AccumulatorJoint mAccumulatorJoint = new AccumulatorJoint();
  private final Indexor mIndexor = new Indexor();
  private final Shooter mShooter = new Shooter();
  private final Limelight mLimelight = new Limelight();
  private final NavX mNavX = new NavX();
  private final Turret mTurret = new Turret();

  SimpleAuto m_autoCommand = new SimpleAuto(mDrivetrain, mTurret, mShooter, mIndexor, mLimelight, mNavX);

  public XboxController xbox1 = new XboxController(0);
  public XboxController xbox2 = new XboxController(1);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    mDrivetrain.setDefaultCommand(
      new DriveWithController(
        mDrivetrain,
        () -> xbox1.getTriggerAxis(Hand.kLeft),
        () -> xbox1.getTriggerAxis(Hand.kRight),
        () -> xbox1.getX(Hand.kRight)
      )
    );
    mLift.setDefaultCommand(
      new OperateLift(
        mLift, 
        () -> xbox1.getY(Hand.kLeft), 
        () -> xbox1.getX(Hand.kLeft)
      )
    );
    mAccumulatorIntake.setDefaultCommand(
      new RunIntake(
        mAccumulatorIntake,
        () -> xbox2.getTriggerAxis(Hand.kRight),
        () -> xbox2.getTriggerAxis(Hand.kLeft)
      )
    );
    mIndexor.setDefaultCommand(
      new OperateIndexor(
        mIndexor, 
        mLEDs,
        () -> xbox2.getAButton(), 
        () -> xbox2.getBButton())
    );
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
      //Shifting to low or high gear
   new JoystickButton(xbox1, Button.kBumperRight.value).whenPressed(new WheelsShiftHigh(mDrivetrain, mLEDs));
   new JoystickButton(xbox1, Button.kBumperLeft.value).whenPressed(new WheelsShiftLow(mDrivetrain, mLEDs));
      //Locking the lift in its current position
   new JoystickButton(xbox1, Button.kY.value).whenPressed(new LiftBrakeOn(mLift, mLEDs));
   new JoystickButton(xbox1, Button.kX.value).whenPressed(new LiftBrakeOff(mLift, mLEDs));
      //Lowering/Raising Accumulator
   new JoystickButton(xbox2, Button.kY.value).whenPressed(new RaiseAccum(mAccumulatorJoint));
   new JoystickButton(xbox2, Button.kX.value).whenPressed(new LowerAccum(mAccumulatorJoint));
      //Swapping to ManualOperateTurret
   new JoystickButton(xbox2, Button.kStickRight.value).whenPressed(new ManualOperateLauncher(mTurret, mShooter, () -> xbox2.getX(Hand.kRight), () -> xbox2.getPOV() * 1.0, () -> xbox2.getStickButton(Hand.kLeft)));
   new JoystickButton(xbox2, Button.kStickLeft.value).whenPressed(new AutoOperateLauncher(mShooter, mTurret, mNavX, mLimelight, () -> xbox2.getBumper(Hand.kRight), () -> xbox2.getBumper(Hand.kLeft), () -> xbox2.getStickButton(Hand.kRight)));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public SequentialCommandGroup getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }



}
