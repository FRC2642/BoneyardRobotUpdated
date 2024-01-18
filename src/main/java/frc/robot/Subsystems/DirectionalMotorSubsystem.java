// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxAnalogSensor;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxAnalogSensor.Mode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DirectionalMotorSubsystem extends SubsystemBase {
  /** Creates a new DirectionalMotorSubsystem. */
  private CANSparkMax motor2 = new CANSparkMax(0, MotorType.kBrushless);

  private SparkMaxAnalogSensor motor2encoder = motor2.getAnalog(Mode.kAbsolute);

  public void runMotor(double speed) {motor2.set(speed);}

  public double getMotorEncoderValue() {return motor2encoder.getPosition() / 4096 * 360;} // returns the angle

  public DirectionalMotorSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
