package org.usfirst.frc.team4915.stronghold.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4915.stronghold.Joysticks;
import org.usfirst.frc.team4915.stronghold.Robot;

/**
 * Arcade drive is when one joystick controls all the wheels, like an arcade
 * game.
 */
public class ArcadeDrive extends Command {

    private final Joystick joystick;

    public ArcadeDrive(Joystick joystick) {
        this.joystick = joystick;
        requires(Robot.DRIVETRAIN);
    }

    @Override
    protected void initialize() {
        requires(Robot.DRIVETRAIN);
    }

    @Override
    protected void execute() {
        double x = this.joystick.getX();
        double y = this.joystick.getY();

        if (!isWithinDeadZone(x, y)) {
            Robot.DRIVETRAIN.arcadeDrive(x, y);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.DRIVETRAIN.arcadeDrive(0, 0);
    }

    @Override
    protected void interrupted() {
        end();
    }

    /**
     * Joysticks most of the time have a slight drift. This checks if
     * {@code (x, y)} is within the dead zone,
     * {@link Joysticks#JOYSTICK_DEAD_ZONE_THRESHOLD} square.
     */
    private boolean isWithinDeadZone(double x, double y) {
        return Math.abs(x) + Math.abs(y) < Joysticks.JOYSTICK_DEAD_ZONE_THRESHOLD * 2;
    }

}
