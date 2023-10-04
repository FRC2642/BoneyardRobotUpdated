// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {}

  CANSparkMax intakeMotorL = new CANSparkMax( 6,MotorType.kBrushless);
  CANSparkMax intakeMotorR = new CANSparkMax( 5,MotorType.kBrushless);

  public void runIntake(double speed)
  {
    intakeMotorL.set(speed);
    intakeMotorR.set(speed * -1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
