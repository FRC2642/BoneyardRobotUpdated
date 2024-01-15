// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.MotorSubsystem;

public class MotorCommand extends CommandBase {
  /** Creates a new MotorCommand. */
  MotorSubsystem motor;
  XboxController control;

  public MotorCommand(MotorSubsystem motorIN, XboxController controlIN) {
    this.motor = motorIN;
    this.control = controlIN;

    addRequirements(motorIN);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (control.getAButton()) {
      motor.runMotor(1 * (control.getRightTriggerAxis()*0.9 + 0.1)); // default run speed 0.1 max 1 when right trigger used
    } else {
      motor.runMotor(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
