package org.usfirst.frc.team3506.robot.domain;

import java.io.Serializable;
import java.util.Arrays;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class RobotInput implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	double leftX, leftY, rightX, rightY;
	public boolean[] leftButtons = new boolean[RobotMap.NUMBER_OF_JOYSTICK_BUTTONS];
	public boolean[] rightButtons = new boolean[RobotMap.NUMBER_OF_JOYSTICK_BUTTONS];
	public static Command[] leftCommands = new Command[RobotMap.NUMBER_OF_JOYSTICK_BUTTONS];
	public static Command[] rightCommands = new Command[RobotMap.NUMBER_OF_JOYSTICK_BUTTONS];
	
	/**
	 * @param booleanArray
	 *            Must be OldRobotInput.leftButtons[] or
	 *            OldRobotInput.rightButtons[]
	 * 
	 * @param buttonNumber
	 *            The value of the button on the joystick
	 * 
	 * @return The value of booleanArray[] at buttonNumber
	 */
	public boolean getButtonState(boolean isLeft, int buttonNumber) {
		if (isLeft) {
			return leftButtons[buttonNumber - 1];
		} else {
			return rightButtons[buttonNumber - 1];
		}
	}

	public void setButtonState(boolean isLeft, int buttonNumber,
			Joystick joystick) {
		if (isLeft) {
			leftButtons[buttonNumber - 1] = joystick.getRawButton(buttonNumber);
		} else {
			rightButtons[buttonNumber - 1] = joystick
					.getRawButton(buttonNumber);
		}
	}

	public void executeButtonCommand(boolean isLeft, int buttonNumber,
			Command command) {
		boolean buttonState = getButtonState(isLeft, buttonNumber);
		if (buttonState) {
			Scheduler.getInstance().add(command);
		}
	}

	public double getJoystickAxis(int joystickPort, int joystickAxisValue) {
		return DriverStation.getInstance().getStickAxis(joystickPort,
				joystickAxisValue);
	}

	public double getLeftX() {
		return leftX;
	}

	public void setLeftX(double leftX) {
		this.leftX = leftX;
	}

	public double getLeftY() {
		return leftY;
	}

	public void setLeftY(double leftY) {
		this.leftY = leftY;
	}

	public double getRightX() {
		return rightX;
	}

	public void setRightX(double rightX) {
		this.rightX = rightX;
	}

	public double getRightY() {
		return rightY;
	}

	public void setRightY(double rightY) {
		this.rightY = rightY;
	}

	@Override
	public String toString() {
		return "RobotInput [leftX=" + leftX + ", leftY=" + leftY + ", rightX="
				+ rightX + ", rightY=" + rightY + ", leftButtons="
				+ Arrays.toString(leftButtons) + ", rightButtons="
				+ Arrays.toString(rightButtons) + "]";
	}
}
