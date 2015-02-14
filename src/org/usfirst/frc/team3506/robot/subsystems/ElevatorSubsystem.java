package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElevatorSubsystem extends Subsystem {
    DigitalInput elevatorUpSwitch, elevatorDownSwitch;
    DoubleSolenoid lifter1, lifter2;
    public ElevatorSubsystem(){
    	elevatorDownSwitch = new DigitalInput(RobotMap.LIMIT_SWITCH_LEFT_LIFTER_DOWN_PORT);
    	elevatorUpSwitch = new DigitalInput(RobotMap.LIMIT_SWITCH_LEFT_LIFTER_UP_PORT);
    	lifter1 = new DoubleSolenoid(RobotMap.SOLENOID_LIFTER_PORT1[0], RobotMap.SOLENOID_LIFTER_PORT1[1]);
    	lifter2 = new DoubleSolenoid(RobotMap.SOLENOID_LIFTER_PORT2[0], RobotMap.SOLENOID_LIFTER_PORT2[1]);
    }
    public void liftElevator(){
    	lifter1.set(Value.kReverse);
    	lifter2.set(Value.kReverse);
    }
    public void lowerElevator(){
    	lifter1.set(Value.kForward);
    	lifter2.set(Value.kForward);
    }
    public boolean getUpperSwitch(){
    	return elevatorUpSwitch.get();
    }
    public boolean getLowerSwitch(){
    	return elevatorDownSwitch.get();
    }
    public void initDefaultCommand() {
    }
}

