// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class JoystickDrive extends CommandBase {
  private final DriveSubsystem driveSubsystem;
  private final static XboxController driverController = RobotContainer.driverController;
  /** Creates a new JoystickDrive. */
  public JoystickDrive(DriveSubsystem drivetrain) {
     
      driveSubsystem = drivetrain;
      addRequirements(driveSubsystem); 
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
double throttle = driverController.getLeftY(); 
double rotate = driverController.getRightX(); 

{ if((throttle > 0 && throttle < 0.25) || (throttle < 0 && throttle > -0.25)) {
  throttle = 0; 
} else { 
  throttle = 0.25* throttle;  
} 
if((rotate > 0 && rotate < 0.25) || (rotate < 0 && rotate > -0.25)) { 
  rotate = 0; 
} else { 
  rotate = 0.25* rotate; 
}

}

/*if (driverController.getRightTriggerAxis() > 0.25) {
  throttle = Math.signum(throttle) * 0.75; 
}
else if (driverController.getAButton()) { 
  throttle = (throttle*1.1);
}
else { 
  throttle = (throttle*0.8);
}*/

// pass back throttle and rotate to driveSubsystem by calling the drive method
  driveSubsystem.drive(throttle, rotate);
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
