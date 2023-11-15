// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShooterCommand extends CommandBase {
  /** Creates a new IntakeCommand. */
  ShooterSubsystem shootsub;
  XboxController control;
  public ShooterCommand(ShooterSubsystem shootsub ,XboxController control) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shootsub = shootsub;
    this.control = control;
    addRequirements(shootsub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  /**
   * 
   */
  @Override
  public void execute() 
  {
   
    if (control.getPOV() == 0){
      shootsub.runIntake(1);
    }
    else if (control.getPOV() == 90){
      shootsub.runIntake(0.5);
    }
    else if (control.getPOV() == 180){
      shootsub.runIntake(-1);
    }    
    else if (control.getPOV() == 270){
      shootsub.runIntake(-0.5);
    }
    else
    {
      shootsub.runIntake(0);
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
