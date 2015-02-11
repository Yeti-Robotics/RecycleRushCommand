package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DistanceSensor extends Subsystem {
    
	private AnalogInput distanceSensor;
	public DistanceSensor(){
		distanceSensor = new AnalogInput(RobotMap.DISTANCE_SENSOR_PORT);
	}
	public double getDistanceFromObstacle(){
		return distanceSensor.getVoltage();
	}
	private double convertVoltageToFeet(double voltage){
		return 0.0; // Please fill in
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

