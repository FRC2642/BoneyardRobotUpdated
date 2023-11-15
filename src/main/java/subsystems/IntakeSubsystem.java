// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

  private CANSparkMax intakeMotor = new CANSparkMax(4, MotorType.kBrushless);
  private PneumaticsControlModule pneumatics = new PneumaticsControlModule(1);

  private DoubleSolenoid leftSolenoid = pneumatics.makeDoubleSolenoid(0, 1);

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
  }


  public void spinIntake(double speed){
    intakeMotor.set(speed);
  }

  public void setIntake(boolean intakeExtended){
    if (intakeExtended){
      leftSolenoid.set(Value.kForward);
    }
    else{
      leftSolenoid.set(Value.kReverse);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
