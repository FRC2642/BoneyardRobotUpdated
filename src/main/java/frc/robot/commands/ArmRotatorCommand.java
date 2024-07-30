// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmRotatorSubsystem;

public class ArmRotatorCommand extends Command {
  private XboxController auxController;
  private ArmRotatorSubsystem armRotator;

  /** Creates a new ArmRotatorCommand. */
  public ArmRotatorCommand(XboxController auxController, ArmRotatorSubsystem armRotator) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.auxController = auxController;
    this.armRotator = armRotator;
    addRequirements(armRotator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = auxController.getRightY();
    ////System.out.println(armRotator.getTilt());

    /*Right Stick Up moves arm up, Right Stick Down moves arm down.
    Idle when Right Stick not Pressed, Moved Left, or Moved Right*/
    if(Math.abs(speed) < 0.1){
    armRotator.rotateArm(0);
    }
      else{
    armRotator.rotateArm(speed);
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