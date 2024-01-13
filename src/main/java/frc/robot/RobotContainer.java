// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.ArmRotatorCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.RunMagazineCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.subsystems.ArmRotatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.MagazineSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class RobotContainer {
  public XboxController control = new XboxController(0);
  public IntakeSubsystem intake = new IntakeSubsystem();
  public ArmRotatorSubsystem arm = new ArmRotatorSubsystem();
  public ShooterSubsystem shooter = new ShooterSubsystem();
  public MagazineSubsystem mag = new MagazineSubsystem();
  public RobotContainer() {
    shooter.setDefaultCommand(new ShooterCommand(shooter, control));
    mag.setDefaultCommand(new RunMagazineCommand(control, mag));
    configureBindings();
    intake.setDefaultCommand(new IntakeCommand(control, intake, mag, arm, shooter));
    arm.setDefaultCommand(new ArmRotatorCommand(control, arm));
  }

  

  private void configureBindings() {
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
