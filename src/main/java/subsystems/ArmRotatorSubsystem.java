// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmRotatorSubsystem extends SubsystemBase {
  private TalonSRX talon = new TalonSRX(13);
  /** Creates a new ArmRotatorSubsystem. */
  public ArmRotatorSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void rotateArm(double speed){
    talon.set(TalonSRXControlMode.PercentOutput, speed*0.3);
  }
}
