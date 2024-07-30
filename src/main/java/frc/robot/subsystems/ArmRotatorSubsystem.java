// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmRotatorSubsystem extends SubsystemBase {
  /** Creates a new ArmRotatorSubsystem. */
  public ArmRotatorSubsystem() {}

  private TalonSRX talon = new TalonSRX(13);
  
  private Encoder tiltEncoder = new Encoder(0, 1);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  //Rotates Arm Up or Down at the speed set in ArmRotatorCommand
  public void rotateArm(double speed){
    talon.set(TalonSRXControlMode.PercentOutput, speed * 0.5);
  }

  public double getTilt(){
    return talon.getSelectedSensorPosition();
  }
}