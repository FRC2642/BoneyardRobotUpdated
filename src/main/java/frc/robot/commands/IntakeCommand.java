// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import javax.security.sasl.AuthorizeCallback;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmRotatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.MagazineSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class IntakeCommand extends CommandBase {

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
    if (auxController.getLeftTriggerAxis() > 0.1){
      if(!timerStarted){
        timer1.start();
        timerStarted = true;
      }
    }


    if(!(timer1.get() > 0)){
      timer1.reset();
      timerStarted = false;
      intake.setIntake(false);
      intake.spinIntake(0);
    }
    else if(timer1.get() < 1) {
      intake.setIntake(true);
    } 
    else if(timer1.get() < 2) {
      //Move Arm Down
      shooter.runShooter(-1);
    } 
    else{
      intake.spinIntake(1);
      shooter.runShooter(-1);
      mag.runMag(0.5);
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