// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {}

  private CANSparkMax intakeMotor = new CANSparkMax(4, MotorType.kBrushless);
  private PneumaticsControlModule pneumatics = new PneumaticsControlModule(1);

  private DoubleSolenoid Solenoid = pneumatics.makeDoubleSolenoid(0, 1);

  //Spins Intake Wheels at speed set in IntakeCommand
  public void spinIntake(double speed){
    intakeMotor.set(speed);
  }

  //Extends or Retracts Intake as wanted in IntakeCommand
  public void setIntake(boolean intakeExtended){
    if (intakeExtended){
      Solenoid.set(Value.kReverse);
    }
    else{
      Solenoid.set(Value.kForward);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}