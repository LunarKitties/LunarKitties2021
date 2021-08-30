package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

import frc.robot.subsystems.Turret;
import java.util.function.DoubleSupplier;

public class ManualOperateTurret extends CommandBase {
  //Main control vars
    public static int maxCWPos = 236;
    public static int maxCCWPos = -270;
    public static int goalCWPos = 220;
    public static int goalCCWPos = -220;
    public static double minSpeed = 0.06;
    public static double kPGoal = 0.035;
    public static double kPEnc = 0.005;
    double currErr, goalEnc, currAngle, speed;
    boolean targetFound;
    private final Turret mTurret;
    private final DoubleSupplier rightStickX2;

    public ManualOperateTurret(Turret _Turret, DoubleSupplier _rightStickX2) {
      mTurret = _Turret;
      rightStickX2 = _rightStickX2;
    }

    @Override
  public void execute(){
    speed = rightStickX2.getAsDouble();
    if (speed > 0.7){
      speed = 0.7;
    }else if (speed < -0.7){
      speed = -0.7;
    }
    mTurret.run(speed);
  }
}