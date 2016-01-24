
package org.usfirst.frc.team4915.stronghold.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4915.stronghold.Motors;
import org.usfirst.frc.team4915.stronghold.commands.ArcadeDrive;

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

}
