package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class NavigationSensorSubsystem extends Subsystem {
	private Gyro gyro;
	private AnalogInput distanceSensor;
	
	public NavigationSensorSubsystem(){
		gyro = new Gyro(RobotMap.GYRO_PORT);
		distanceSensor = new AnalogInput(RobotMap.DISTANCE_SENSOR_PORT);
	}
	public double getDistanceFromObstacle(){
		return convertVoltageToFeet(distanceSensor.getVoltage());
	}
	private double convertVoltageToFeet(double voltage){
		return (100.0/12.0)*voltage + (7.0/60.0);
	}
	public double getGyroAngle(){
		return gyro.getAngle();
	}
	public void resetGyro(){
		gyro.reset();
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

