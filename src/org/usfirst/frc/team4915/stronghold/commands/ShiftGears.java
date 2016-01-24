package org.usfirst.frc.team4915.stronghold.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4915.stronghold.Robot;
import org.usfirst.frc.team4915.stronghold.subsystems.Drivetrain.Gear;

/**
 * This command merely executes
 * {@link org.usfirst.frc.team4915.stronghold.subsystems.Drivetrain#shift} when
 * executed.
 */
public class ShiftGears extends Command {

    private final Gear targetGear;

    /**
     * Set the {@link Gear} to shift to when this command is executed.
     * 
     * @param targetGear The gear to shift to
     */
    public ShiftGears(Gear targetGear) {
        this.targetGear = targetGear;
        requires(Robot.DRIVETRAIN);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.DRIVETRAIN.shift(targetGear);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }

}
