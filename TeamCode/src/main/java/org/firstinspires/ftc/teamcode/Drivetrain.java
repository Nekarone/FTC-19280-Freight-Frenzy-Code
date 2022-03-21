package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.TankDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor.Encoder;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.Base64;

public class Drivetrain extends CommandBase{
    private final TankDrive m_drivetrain;
    private final Encoder m_left, m_right;
    private final Double WHEEL_DIAMETER;

    public Drivetrain(MotorEx leftMotor, MotorEx rightMotor, final double diameter){
        m_left = leftMotor.encoder;
        m_right = rightMotor.encoder;

        WHEEL_DIAMETER = diameter;
        m_drivetrain = new TankDrive(leftMotor, rightMotor);
    }

    public void tankDrive(double spd){
        m_drivetrain.tankDrive(spd, spd);
    }
}
