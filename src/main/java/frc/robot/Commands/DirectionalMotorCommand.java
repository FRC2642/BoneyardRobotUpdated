// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.DirectionalMotorSubsystem;

public class DirectionalMotorCommand extends CommandBase {
  /** Creates a new DirectionalMotorCommand. */
  DirectionalMotorSubsystem motor;
  XboxController control;

  double startingAngle;
  double angleDiff; // the angle to initally subtract from the angle outputted by the encoder

  public DirectionalMotorCommand(DirectionalMotorSubsystem motorIN, XboxController controlIN) {
    this.motor = motorIN;
    this.control = controlIN;

    addRequirements(motorIN);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startingAngle = motor.getMotorEncoderValue() % 360;
    angleDiff = Math.floor(motor.getMotorEncoderValue() / 360);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (control.getYButton()) {
      motor.runMotor(0.1);
      
    } else if (control.getXButton()) {
      motor.runMotor(-0.1);
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
