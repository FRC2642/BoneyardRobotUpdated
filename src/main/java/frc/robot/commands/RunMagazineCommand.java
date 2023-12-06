// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MagazineSubsystem;

public class RunMagazineCommand extends CommandBase {
  /** Creates a new RunMagazineCommand. */
  XboxController control;
  MagazineSubsystem mag;
  public RunMagazineCommand(XboxController control, MagazineSubsystem mag) {
    this.control = control;
    this.mag = mag;
    addRequirements(mag);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    /*A Button moves Belt away from the shooter, 
    B Button moves Belt towards the shooter,
    if neither Button is Pressed Belt will be Idle.*/
    if (control.getAButton()){
      mag.runMag(0.5);
    }
    else if (control.getBButton()){
      mag.runMag(-0.5);
    }
    else{
      mag.runMag(0);
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
