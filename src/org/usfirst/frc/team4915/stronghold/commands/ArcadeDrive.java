
package org.usfirst.frc.team4915.stronghold.commands;

import org.usfirst.frc.team4915.stronghold.Robot;
import org.usfirst.frc.team4915.stronghold.vision.robot.VisionState;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDrive extends Command {

    public Joystick joystickDrive;
    private double joystickX;
    private double joystickY;
    private double joystickZ;

    public ArcadeDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        this.joystickDrive = Robot.oi.getJoystickDrive();
        this.joystickX = this.joystickDrive.getAxis(Joystick.AxisType.kX);
        this.joystickY = this.joystickDrive.getAxis(Joystick.AxisType.kY);
        this.joystickZ = this.joystickDrive.getAxis(Joystick.AxisType.kZ);
        Robot.driveTrain.trackGyro();

        Robot.driveTrain.joystickThrottle = Robot.driveTrain.modifyThrottle();
        // checks where the joystick is
        if (VisionState.getInstance().AutoAimEnabled) {
            int Vis = VisionState.getInstance().TargetX;
            if (Vis <= -1) {
                Robot.driveTrain.turn(false);
            } else {
                Robot.driveTrain.turn(true);
            }

        } else if ((Math.abs(this.joystickX) < Math.abs(0.075)) && (Math.abs(this.joystickY) < Math.abs(0.075))) {

            Robot.driveTrain.stop();
        } else {
            Robot.driveTrain.arcadeDrive(this.joystickDrive);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }

}
