// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  public ShooterSubsystem() {}

  CANSparkMax shooterMotorL = new CANSparkMax( 11,MotorType.kBrushless);
  CANSparkMax shooterMotorR = new CANSparkMax( 12,MotorType.kBrushless);

  public void runIntake(double speed)
  {
    shooterMotorL.set(speed);
    shooterMotorR.set(speed * -1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}