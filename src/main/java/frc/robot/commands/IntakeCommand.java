// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

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
  private Timer timer2 = new Timer();

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
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = auxController.getLeftTriggerAxis();
    System.out.println(timer1.get());
    System.out.println(timer2.get());

    /*When Left Trigger Pressed, It will extend the Intake, if not already
    extended, and spin the intake*/
    if(speed > 0.1){
      if(!timeWaited){
        //if(motor.getEncoderTick higher than safety){
          intake.setIntake(true);
          timer1.start();
          if(timer1.get() >= 1){
            //lower arm to feeding position
            shooter.runShooter(-1);
            timer2.start();
            if(timer2.get() >= 1){
              intake.spinIntake(speed);
              mag.runMag(0.5);
              timeWaited = true;
              timer1.reset();
              timer2.reset();
            }
          }
        //}
      }
      else{
        shooter.runShooter(-1);
        intake.spinIntake(speed);
        mag.runMag(0.5);
      }
    }

    /*On Release of Left Trigger, the Intake will Stop and Retract if Extended.
    Intake is Idle without use of Left Trigger*/
    else{
      timeWaited = false;
      //if(motor.getEncoderTicks lower than safety){
          //Raise Arm above Safety
      //}
      //else{
          intake.setIntake(false);
      //}
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