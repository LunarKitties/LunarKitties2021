package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.kauailabs.navx.frc.AHRS;

public class NavX extends SubsystemBase {
    AHRS navX = new AHRS();

    public NavX(){}

    public void calibrate(){
        navX.calibrate();
    }  

    public void reset(){
        navX.reset();
    }

    public double getAngle(){
        return navX.getAngle() % 360;
    }

    public void log(){
        SmartDashboard.putNumber("NavX Gyro", getAngle());
    }
}
