// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Commands.MotorCommand;
import frc.robot.Subsystems.MotorSubsystem;

public class RobotContainer {
  //subsystems
  private final MotorSubsystem motor = new MotorSubsystem();

  //Xbox Controllers
  private final XboxController control = new XboxController(0);

  public RobotContainer() {
    motor.setDefaultCommand(new MotorCommand(motor, control));

    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
