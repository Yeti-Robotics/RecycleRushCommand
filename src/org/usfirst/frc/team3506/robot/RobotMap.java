package org.usfirst.frc.team3506.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// Encoder ports ()
	public static final int[] ENCODER_LEFT_DRIVE_TRAIN_PORT = {3,4};
	public static final int[] ENCODER_RIGHT_DRIVE_TRAIN_PORT = {5,6};
	public static final int[] ENCODER_ARM_LEFT = {7,8};
	public static final int[] ENCODER_ARM_RIGHT = {0,1};
	public static final double DISTANCE_PER_PULSE = 0.006;
	// Distance per pulse = (Cicumference)/[(TICKS PER SECOND)*(TIME FOR 1 REVOLUTION)]
	
	// PCM ID
	public static final int PCM_ID = 0;
	
	// Solenoid ports (PCM)
	public static final int[] SOLENOID_LEFT_CLAW_PORT = {0,1};
	public static final int[] SOLENOID_RIGHT_CLAW_PORT = {2,3};
	public static final int[] SOLENOID_LIFTER_PORT1 = {4,5};
	public static final int[] SOLENOID_LIFTER_PORT2 = {6,7};
	
	// Talon ports (PWM)
	public static final int TALON_LEFT_FRONT_WHEEL_PORT = 0;
	public static final int TALON_LEFT_REAR_WHEEL_PORT = 1;
	public static final int TALON_RIGHT_FRONT_WHEEL_PORT = 5;
	public static final int TALON_RIGHT_REAR_WHEEL_PORT = 4;
	public static final int TALON_RIGHT_ARM_PORT = 2;
	public static final int TALON_LEFT_ARM_PORT = 3;
	
	// Relays
	public static final int SPIKE_CLAW_BELT_PORT = 0;
	
	// Joysticks
	public static final int JOYSTICK_LEFT_PORT = 1;
	public static final int JOYSTICK_RIGHT_PORT = 2;
	public static final int JOYSTICK_ARM_PORT = 0;
	public static final double JOYSTICK_DEADZONE = 0.1;
	
	// Robot parameters
	public static final double ROBOT_DIAMETER_FT = 2.125;
	public static final double ROBOT_SPEED_MOD_INC = 0.01;
	public static final double DEGREES_PER_PULSE = 0.25;
	
	// Distance sensor
	public static final int DISTANCE_SENSOR_PORT = 7;
	
	// Info for saving arm encoder position
	public static final String CAMERA_ID = "cam0";
	public static final double DEFAULT_ARM_SPEED = 0.2;
}
