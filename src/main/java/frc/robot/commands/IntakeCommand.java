// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import javax.security.sasl.AuthorizeCallback;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmRotatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.MagazineSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class IntakeCommand extends Command {

  private final XboxController auxController;
  private IntakeSubsystem intake;
  private ArmRotatorSubsystem arm;
  private ShooterSubsystem shooter;
  private MagazineSubsystem mag;
  private boolean timeWaited = false;
  private Timer timer1 = new Timer();
  private boolean timerStarted = false;
  /** Creates a new IntakeCommand. */
  public IntakeCommand(XboxController controller, IntakeSubsystem intake, MagazineSubsystem mag, ArmRotatorSubsystem arm, ShooterSubsystem shooter) {
    this.auxController = controller;
    this.intake = intake;
    this.arm = arm;
    this.shooter = shooter;
    this.mag = mag;
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

 
  @Override
  public void execute() {
    if (auxController.getLeftTriggerAxis() >= 0.1){
      intake.setIntake(true);
      intake.spinIntake(0.8);
    }
    else{
      intake.setIntake(false);
      intake.spinIntake(0);
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