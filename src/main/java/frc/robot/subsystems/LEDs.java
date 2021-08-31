package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LEDs extends SubsystemBase {

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
Spark ledDriver = new Spark(Constants.PWM_BLINKIN);

public static final double RAINBOW = -0.99;
public static final double RAINBOW_OCEAN = -0.95;
public static final double RAINBOW_FOREST = -0.91;
public static final double BPM_RAINBOW = -0.69;
public static final double STROBE_RED = -0.11;
public static final double STROBE_BLUE = -0.09;
public static final double STROBE_GOLD = -0.07;
public static final double CHASE_RED = -0.35;
public static final double SPECIAL_CHASE = .45;
public static final double SLOW_BREATHE_COLOR2 = 0.29;
public static final double RED = 0.61;
public static final double ORANGE = 0.65;
public static final double GOLD_PATTERN = 0.41;
public static final double LAWN_GREEN = 0.71;


  public void initDefaultCommand() {
      // Set the default command for a subsystem here.
      //setDefaultCommand(new MySpecialCommand());
    //setDefaultCommand(new MonitorLEDS());
  }
  
  public void setColor(double color)
  {
    ledDriver.set(color);
  }
}