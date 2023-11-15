// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.commands.ArmRotatorCommand;
import frc.commands.IntakeCommand;
import subsystems.ArmRotatorSubsystem;
import subsystems.IntakeSubsystem;

public class RobotContainer {
  public XboxController control = new XboxController(0);
  public IntakeSubsystem intake = new IntakeSubsystem();
  public ArmRotatorSubsystem armRotator = new ArmRotatorSubsystem();
  public ShooterSubsystem shootsub = new ShooterSubsystem();
  public MagazineSubsystem mag = new MagazineSubsystem();
  public RobotContainer() {
    shootsub.setDefaultCommand(new ShooterCommand(shootsub, control));
    mag.setDefaultCommand(new RunMagazineCommand(control, mag));
    configureBindings();
    intake.setDefaultCommand(new IntakeCommand(control, intake, false));
    armRotator.setDefaultCommand(new ArmRotatorCommand(control, armRotator));
  }

  

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
