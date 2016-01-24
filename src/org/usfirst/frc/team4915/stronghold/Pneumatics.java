package org.usfirst.frc.team4915.stronghold;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * This class is a registry of all the pneumatic cylinders on the robot.
 */
public class Pneumatics {

    /**
     * This is the pneumatic compressor on the robot.
     */
    public static final Compressor COMPRESSOR = new Compressor(0);

    /**
     * These solenoids control gear shifting in the two-speed gearbox for each
     * of the driving motors. Extending in either direction (forward or reverse)
     * controls what gear is selected.
     */
    public static final DoubleSolenoid GEARBOX_FRONT_LEFT = new DoubleSolenoid(0, 0);
    public static final DoubleSolenoid GEARBOX_FRONT_RIGHT = new DoubleSolenoid(0, 0);
    public static final DoubleSolenoid GEARBOX_REAR_LEFT = new DoubleSolenoid(0, 0);
    public static final DoubleSolenoid GEARBOX_REAR_RIGHT = new DoubleSolenoid(0, 0);

    static {

        /*
         * Ensure that the solenoids start disabled when the robot is turned on.
         */
        GEARBOX_FRONT_LEFT.set(Value.kOff);
        GEARBOX_FRONT_RIGHT.set(Value.kOff);
        GEARBOX_REAR_LEFT.set(Value.kOff);
        GEARBOX_REAR_RIGHT.set(Value.kOff);

        /*
         * Ensure the compressor automatically handles pressurization.
         */
        COMPRESSOR.setClosedLoopControl(true);

    }

}
