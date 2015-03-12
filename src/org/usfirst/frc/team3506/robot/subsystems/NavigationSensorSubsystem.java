package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class NavigationSensorSubsystem extends Subsystem {
	private DigitalInput autoSwitch;
	private Gyro gyro;
	private AnalogInput distanceSensor;
	
	public NavigationSensorSubsystem(){
		autoSwitch = new DigitalInput(RobotMap.AUTOSWITCHPORT);
		gyro =  new Gyro(RobotMap.GYRO_PORT);
		distanceSensor = new AnalogInput(RobotMap.SONAR_SENSOR_PORT);
	}
    public void initDefaultCommand() {
    }
	
	public boolean autoSwitchState() {
		return autoSwitch.get();
	}
	
	public double getDistanceFromObstacle(){
		return convertVoltageToInches(distanceSensor.getVoltage());
	}
	private double convertVoltageToInches(double voltage){
		return 124.982*voltage - 3.33109;
	}
	public double getSonarVoltage() {
		return distanceSensor.getVoltage();
	}
	public Gyro getGyro() {
		return gyro;
	}
	public double getGyroAngle(){
		return gyro.getAngle();
	}
	public void resetGyro(){
		gyro.reset();
	}

}

