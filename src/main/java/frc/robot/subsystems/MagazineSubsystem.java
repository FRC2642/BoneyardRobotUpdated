// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class MagazineSubsystem extends SubsystemBase {
  /** Creates a new MagazineSubsystem. **/
  public MagazineSubsystem() {}

  private TalonSRX talon = new TalonSRX(14);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  //Moves Mag Towards or Away from Shooter as wanted in RunMagazineCommand
  public void runMag(double speed){
    talon.set(TalonSRXControlMode.PercentOutput, speed);
  }
}