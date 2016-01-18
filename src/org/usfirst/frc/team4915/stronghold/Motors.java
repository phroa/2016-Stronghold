package org.usfirst.frc.team4915.stronghold;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * This class is a registry of all the motors on the robot.
 */
public class Motors {

    /**
     * On our secondary robot, the motor port numbers are ten higher than on the
     * competition robot.
     */
    private static final int MOTOR_PORT_OFFSET = Robot.ROBOT_TYPE == RobotType.PRIMARY ? 0 : 10;

    public static final SpeedController FRONT_LEFT = new CANTalon(10 + MOTOR_PORT_OFFSET);
    public static final SpeedController FRONT_RIGHT = new CANTalon(12 + MOTOR_PORT_OFFSET);
    public static final SpeedController REAR_LEFT = new CANTalon(11 + MOTOR_PORT_OFFSET);
    public static final SpeedController REAR_RIGHT = new CANTalon(13 + MOTOR_PORT_OFFSET);

}
