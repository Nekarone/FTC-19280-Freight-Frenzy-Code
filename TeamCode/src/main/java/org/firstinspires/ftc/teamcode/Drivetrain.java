package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.DifferentialDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor.Encoder;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;


import java.util.Base64;

public class Drivetrain extends SubsystemBase {
    private final DifferentialDrive m_drivetrain;
    private final Encoder m_left, m_right;
    private final Double WHEEL_DIAMETER;

    public Drivetrain(MotorEx leftMotor, MotorEx rightMotor, final double diameter){
        m_left = leftMotor.encoder;
        m_right = rightMotor.encoder;

        WHEEL_DIAMETER = diameter;
        m_drivetrain = new DifferentialDrive(leftMotor, rightMotor);
    }

    public void tankDrive(double spd){
        m_drivetrain.tankDrive(spd, spd);
    }

    public void arcadeDrive(double forwardSpd, double turnSpd){
        m_drivetrain.arcadeDrive(forwardSpd, turnSpd);
    }

    public double getLeftEncoderVal(){
        return m_left.getPosition();
    }

    public double getLeftEncoderDistance(){
        return m_left.getRevolutions() * WHEEL_DIAMETER * Math.PI;
    }

    public double getRightEncoderVal(){
        return m_right.getPosition();
    }

    public double getRightEncoderDistance(){
        return m_right.getRevolutions() * WHEEL_DIAMETER * Math.PI;
    }

    public void resetEncoders(){
        m_left.reset();
        m_right.reset();
    }

    public double getAverageEncoderDistance(){
        return (getLeftEncoderDistance() + getRightEncoderDistance()) / 2.0;
    }



}
