
package org.usfirst.frc.team4915.stronghold.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4915.stronghold.Motors;
import org.usfirst.frc.team4915.stronghold.Pneumatics;
import org.usfirst.frc.team4915.stronghold.commands.ArcadeDrive;

import java.util.Arrays;

/**
 * The drivetrain is the everytihng that moves, as well as the driving joystick.
 */
public class Drivetrain extends Subsystem {

    private final RobotDrive robotDrive = new RobotDrive(Motors.FRONT_LEFT, Motors.REAR_LEFT, Motors.FRONT_RIGHT, Motors.REAR_RIGHT);
    private final Joystick joystick;

    public Drivetrain(Joystick joystick) {
        this.joystick = joystick;
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDrive(this.joystick));
    }

    public void arcadeDrive(double x, double y) {
        this.robotDrive.arcadeDrive(x, y);
    }

    /**
     * Tries to shift to the target gear.
     * 
     * Shifting to {@link Gear#LOW} is done by firing the gearbox solenoids in
     * reverse. Shifting to {@link Gear#HIGH} is done by firing them all
     * forward.
     * 
     * @param targetGear Gear to try and shift to
     */
    public void shift(Gear targetGear) {
        switch (targetGear) {
            case LOW:
                fireGearboxSolenoids(Value.kReverse);
                break;
            case HIGH:
                fireGearboxSolenoids(Value.kForward);
                break;
            default:
                System.out.println("Tried to shift to gear " + targetGear + " which isn't one of " + Arrays.toString(Gear.values()));
        }
    }

    /**
     * Sets all four gearbox solenoids to move in the specified
     * {@code direction}.
     * 
     * @param direction Solenoid direction
     */
    private void fireGearboxSolenoids(Value direction) {
        Pneumatics.GEARBOX_FRONT_LEFT.set(direction);
        Pneumatics.GEARBOX_FRONT_RIGHT.set(direction);
        Pneumatics.GEARBOX_REAR_LEFT.set(direction);
        Pneumatics.GEARBOX_REAR_RIGHT.set(direction);
    }

    public static enum Gear {

        /**
         * Low gear. This is slightly slower but has more torque. Shift here by
         * firing gearbox solenoids in reverse.
         */
        LOW,

        /**
         * Higher gear. This is slightly faster but has less torque. Shift here
         * by firing gearbox solenoids forward.
         */
        HIGH

    }

}
