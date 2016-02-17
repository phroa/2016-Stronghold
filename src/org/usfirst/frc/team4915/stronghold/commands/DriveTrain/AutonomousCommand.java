package org.usfirst.frc.team4915.stronghold.commands.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4915.stronghold.Defense;

public class AutonomousCommand extends Command {

    private final int startingPosition;
    private final Defense startingDefense;

    public AutonomousCommand(int startingPosition, Defense startingDefense) {
        this.startingPosition = startingPosition;
        this.startingDefense = startingDefense;

        System.out.printf("Current autonomous settings: position %d, defense %s\n", startingPosition, startingDefense);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        switch (startingDefense) {
            case CHEVAL_DE_FRIES:
            case DRAWBRIDGE:
            case PORTCULLIS:
            case SALLY_PORT:
                /* we can't do anything with these defenses */
                return;
        }
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
