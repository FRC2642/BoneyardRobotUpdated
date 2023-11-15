// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {

  private final XboxController auxController;
  private final IntakeSubsystem intake;
  private boolean isExtended = false;

  /** Creates a new IntakeCommand. */
  public IntakeCommand(XboxController controller, IntakeSubsystem intake, boolean isExtended) {
    this.auxController = controller;
    this.intake = intake;
    this.isExtended = isExtended;
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = auxController.getLeftTriggerAxis();
    
    if(speed > 0.1){
      if(isExtended == false){
        isExtended = true;
        intake.setIntake(!isExtended);
      }
      intake.spinIntake(speed);
    }
    else{
      if(isExtended == true){
        isExtended = false;
        intake.setIntake(!isExtended);
      }
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