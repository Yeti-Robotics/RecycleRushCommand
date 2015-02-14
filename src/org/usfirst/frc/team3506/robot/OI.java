package org.usfirst.frc.team3506.robot;

import org.usfirst.frc.team3506.robot.commands.LoadRecordingCommand;
import org.usfirst.frc.team3506.robot.commands.RecordCommand;
import org.usfirst.frc.team3506.robot.commands.arm.MoveArmDownCommand;
import org.usfirst.frc.team3506.robot.commands.arm.MoveArmUpCommand;
import org.usfirst.frc.team3506.robot.commands.arm.ResetArmEncoderCommand;
import org.usfirst.frc.team3506.robot.commands.claw.CloseClawCommand;
import org.usfirst.frc.team3506.robot.commands.claw.OpenClawCommand;
import org.usfirst.frc.team3506.robot.commands.claw.TurnForwardBeltCommand;
import org.usfirst.frc.team3506.robot.commands.claw.TurnOffBeltCommand;
import org.usfirst.frc.team3506.robot.commands.claw.TurnReverseBeltCommand;
import org.usfirst.frc.team3506.robot.commands.compressor.TurnOffCompressorCommand;
import org.usfirst.frc.team3506.robot.commands.compressor.TurnOnCompressorCommand;
import org.usfirst.frc.team3506.robot.commands.drive.UniversalDriveCommand;
import org.usfirst.frc.team3506.robot.commands.elevator.LiftElevatorCommand;
import org.usfirst.frc.team3506.robot.commands.elevator.LowerElevatorCommand;
import org.usfirst.frc.team3506.robot.commands.scheduler.RebootSchedulerCommand;
import org.usfirst.frc.team3506.robot.domain.RobotInput;

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
		setJoystickButtonCommand(leftDriveJoy, 1, new RebootSchedulerCommand());
		setJoystickButtonCommand(leftDriveJoy, 8, new TurnOnCompressorCommand());
		setJoystickButtonCommand(leftDriveJoy, 9, new TurnOffCompressorCommand());
		setJoystickButtonCommand(leftDriveJoy, 2, new RecordCommand());
		setJoystickButtonCommand(leftDriveJoy, 3, new LoadRecordingCommand());

		// Right Drive Joystick
		setJoystickButtonCommand(rightDriveJoy, 3, new LiftElevatorCommand());
		setJoystickButtonCommand(rightDriveJoy, 2, new LowerElevatorCommand());
		setJoystickButtonCommand(rightDriveJoy, 9, new UniversalDriveCommand(90, 0, 0.1));
		setJoystickButtonCommand(rightDriveJoy, 10, new UniversalDriveCommand(0, 3, 0.2));
		
		// Arm Joystick
		setJoystickButtonCommand(armJoy, 2, new CloseClawCommand());
		setJoystickButtonCommand(armJoy, 3, new OpenClawCommand());
		setJoystickButtonCommand(armJoy, 1, new ResetArmEncoderCommand());
		setJoystickButtonCommand(armJoy, 6, new MoveArmUpCommand());
		setJoystickButtonCommand(armJoy, 7, new MoveArmDownCommand());
		setJoystickButtonCommand(armJoy, 11, new TurnForwardBeltCommand());
		setJoystickButtonCommand(armJoy, 10, new TurnReverseBeltCommand());
		setJoystickButtonCommand(armJoy, 9, new TurnOffBeltCommand());
	}
	public double getLeftX() {
		return deadZoneMod(leftDriveJoy.getX());
	}
	public double getLeftY(){
		return deadZoneMod(leftDriveJoy.getY());
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
			return joyVal / 2.0;
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
		if (leftDriveJoy == joystick) {
			RobotInput.leftCommands[button - 1] = command;
		} else if (rightDriveJoy == joystick) {
			RobotInput.rightCommands[button - 1] = command;	
		}
	}
}

