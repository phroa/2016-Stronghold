package org.usfirst.frc.team4915.stronghold;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is where the joysticks attached to the driver station are listed.
 */
public class Joysticks {

    /**
     * The radius of the dead zone square. This is in the range {@code [0, 1]}.
     */
    public static final double JOYSTICK_DEAD_ZONE_THRESHOLD = 0.075;

    /**
     * The main drive stick.
     */
    public static final Joystick DRIVE = new Joystick(0);

}
