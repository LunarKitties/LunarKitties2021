/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  //NEO CAN IDs
    //shooter
  public static int CAN_L_SHOOTER_MOTOR = 8;
  public static int CAN_R_SHOOTER_MOTOR = 9;
    //drivetrain
  public static int CAN_RF_DRIVE_MOTOR = 2;
  public static int CAN_RM_DRIVE_MOTOR = 3;
  public static int CAN_RB_DRIVE_MOTOR = 4;
  public static int CAN_LF_DRIVE_MOTOR = 5;
  public static int CAN_LM_DRIVE_MOTOR = 6;
  public static int CAN_LB_DRIVE_MOTOR = 7;

  //Talon CAN IDs
    //indexor
  public static int CAN_TALON_INDEX_MOTOR = 11;
  public static int CAN_TALON_PRE_SHOOT_MOTOR = 10;
    //turret
  public static int CAN_TALON_TURRET_MOTOR = 13;
    //accumulator
  public static int CAN_TALON_INTAKE_MOTOR = 14;
  public static int CAN_VICTOR_ADJUST_MOTOR = 16;
    //lift
  public static int CAN_VICTOR_LIFT_MOTOR = 12;  
  public static int CAN_TALON_SKYWALKER_MOTOR = 15;

  //PCM Ports
  public static final int PCM_DRIVE_S_OUT = 2;
  public static final int PCM_DRIVE_S_IN = 3;
  public static final int PCM_BRAKE_OUT = 0;
  public static final int PCM_BRAKE_IN = 1;

  //PWM Ports
  public static final int PWM_BLINKIN = 0;

  //DIO Ports
  public static final int DIO_TURRET_A_ENCODER = 0;
  public static final int DIO_TURRET_B_ENCODER = 1;
  public static final int DIO_INDEX_A_ENCODER = 2;
  public static final int DIO_INDEX_B_ENCODER = 3;
  public static final int DIO_ACCUM_A_ENCODER = 4;
  public static final int DIO_ACCUM_B_ENCODER = 5;
  public static final int DIO_INDEX_RIGHT_BALL_SWITCH = 7;
  public static final int DIO_INDEX_LEFT_BALL_SWITCH = 8;
  
  //Analog Input Ports

  //Global variables used

  //Encoder values
  public static final int AccumUp = 30;
  public static final int AccumDown = 500;
}
