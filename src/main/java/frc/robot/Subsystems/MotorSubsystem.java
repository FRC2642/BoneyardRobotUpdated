// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsystem extends SubsystemBase {
  private CANSparkMax motor1 = new CANSparkMax(0, MotorType.kBrushless);

  //private SparkMaxAnalogSensor absEncoder1 = motor1.getAnalog(Mode.kAbsolute);

  public void runMotor(double motorspeed) {
    motor1.set(motorspeed);
  }

  /** Creates a new MotorSubsystem. */
  public MotorSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
