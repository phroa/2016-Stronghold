package org.usfirst.frc.team4915.stronghold;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team4915.stronghold.commands.ShiftGears;
import org.usfirst.frc.team4915.stronghold.subsystems.Drivetrain.Gear;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    /**
     * These buttons control the gear shifter.
     */
    public static final JoystickButton SHIFT_LOW_GEAR = new JoystickButton(Joysticks.DRIVE, 0);
    public static final JoystickButton SHIFT_HIGH_GEAR = new JoystickButton(Joysticks.DRIVE, 0);

    static {

        /*
         * Tie the buttons to the {@link ShiftGear} command when they are
         * pressed.
         */
        SHIFT_LOW_GEAR.whenPressed(new ShiftGears(Gear.LOW));
        SHIFT_HIGH_GEAR.whenPressed(new ShiftGears(Gear.HIGH));

    }

}
