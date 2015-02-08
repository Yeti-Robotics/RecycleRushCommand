package org.usfirst.frc.team3506.robot;

import org.usfirst.frc.team3506.robot.commands.CloseClawCommand;
import org.usfirst.frc.team3506.robot.commands.LiftElevatorCommand;
import org.usfirst.frc.team3506.robot.commands.LowerElevatorCommand;
import org.usfirst.frc.team3506.robot.commands.OpenClawCommand;
import org.usfirst.frc.team3506.robot.commands.ResetArmEncoderCommand;
import org.usfirst.frc.team3506.robot.commands.RestartSchedulerCommandGroup;
import org.usfirst.frc.team3506.robot.commands.TurnBeltMotorReverseCommand;
import org.usfirst.frc.team3506.robot.commands.TurnOffBeltMotorCommand;
import org.usfirst.frc.team3506.robot.commands.TurnOnBeltMotorCommand;
import org.usfirst.frc.team3506.robot.commands.TurnOnCompressorCommand;
import org.usfirst.frc.team3506.robot.commands.UniversalDriveCommand;
import org.usfirst.frc.team3506.robot.commands.UserDriveCommandGroup;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// Joysticks
	private static Joystick leftDriveJoy;
	private static Joystick rightDriveJoy;
	private static Joystick armJoy;

	public OI(){
		leftDriveJoy = new Joystick(RobotMap.JOYSTICK_LEFT_PORT);
		rightDriveJoy = new Joystick(RobotMap.JOYSTICK_RIGHT_PORT);
		armJoy = new Joystick(RobotMap.JOYSTICK_ARM_PORT);
		// Commands and buttons
		
		// Left Drive Joystick
		setJoystickButtonCommand(leftDriveJoy, 8, new RestartSchedulerCommandGroup());
		/*setJoystickButtonCommand(leftDriveJoy, 8, new TurnOnCompressorCommand());
		setJoystickButtonCommand(leftDriveJoy, 9, new TurnOnCompressorCommand());

		// Right Drive Joystick
		setJoystickButtonCommand(rightDriveJoy, 1, new UserDriveCommandGroup());
		setJoystickButtonCommand(rightDriveJoy, 2, new LiftElevatorCommand());
		setJoystickButtonCommand(rightDriveJoy, 3, new LowerElevatorCommand());
		setJoystickButtonCommand(rightDriveJoy, 9, new UniversalDriveCommand(90, 0, 0.25));
		
		// Arm Joystick
		 * */
		setJoystickButtonCommand(armJoy, 1, new CloseClawCommand());
		setJoystickButtonCommand(armJoy, 2, new OpenClawCommand());
		setJoystickButtonCommand(armJoy, 8, new ResetArmEncoderCommand());
		setJoystickButtonCommand(armJoy, 10, new TurnOnBeltMotorCommand());
		setJoystickButtonCommand(armJoy, 11, new TurnOffBeltMotorCommand());
		setJoystickButtonCommand(armJoy, 9, new TurnBeltMotorReverseCommand());
		
	}
	public double getLeftX() {
		return deadZoneMod(leftDriveJoy.getX());
	}
	public double getLeftY(){
		return -deadZoneMod(leftDriveJoy.getY());
	}
	public double getRightX(){
		return deadZoneMod(rightDriveJoy.getX());
	}
	public double getRightY(){
		return deadZoneMod(rightDriveJoy.getY());
	}
	public double getArmY(){
		return deadZoneMod(armJoy.getY());
	}
	public double getArmZ(){
		return deadZoneMod(armJoy.getZ());
	}
	private double deadZoneMod(double joyVal){
		if (Math.abs(joyVal) > RobotMap.JOYSTICK_DEADZONE) {
			return joyVal;
		} else {
			return 0.0;
		}
	}
	public Joystick getLeftDriveJoy(){
		return leftDriveJoy;
	}
	public Joystick getRightDriveJoy(){
		return rightDriveJoy;
	}
	private void setJoystickButtonCommand(Joystick joystick, int button, Command command) {
		new JoystickButton(joystick, button).whenPressed(command);
	}
}

