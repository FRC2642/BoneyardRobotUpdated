// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeCommand extends CommandBase {
  /** Creates a new IntakeCommand. */
  IntakeSubsystem intakesub;
  XboxController control;
  public IntakeCommand(IntakeSubsystem intakesub ,XboxController control) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.intakesub = intakesub;
    this.control = control;
    addRequirements(intakesub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    switch(control.getPOV()){
      case 0:
        intakesub.runIntake(0.5);
      case 90:
        intakesub.runIntake(0.25);
      case 180:
        intakesub.runIntake(-0.5);
      case 360:
        intakesub.runIntake(-0.25);
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
