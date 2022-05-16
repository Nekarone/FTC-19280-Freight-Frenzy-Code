package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor.Encoder;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;

public class Arm extends SubsystemBase{
    public Motor arm_motor_1, arm_motor_2;
    public MotorGroup arm_motors;
    public double MOTOR_TOLERANCE = 5;
    public double DISTANCE_PER_PULSE = 0.015;
    public double POSITION_COEFFICIENT = 0.01;

    public Arm(Motor am1){
        arm_motor_1 = am1;

        arm_motors = new MotorGroup(arm_motor_1);

        arm_motors.setRunMode(Motor.RunMode.RawPower);
        /*
        //Set the mode of the Motor to Position Control
        arm_motors.setRunMode(Motor.RunMode.PositionControl);

        //Set position of position coefficient
        arm_motors.setPositionCoefficient(POSITION_COEFFICIENT);
        arm_motors.setPositionTolerance(MOTOR_TOLERANCE);
        arm_motors.setDistancePerPulse(DISTANCE_PER_PULSE);
        */
        //Reset Encoders
        resetEncoders();
    }

    public void resetEncoders(){
        arm_motors.resetEncoder();
    }

    public void runMotors(double spd){
        arm_motors.set(spd);
    }

    public void stopMotors(){
        arm_motors.stopMotor();
    }

    public void setDistance(double d){
        double pos = arm_motor_1.getCurrentPosition();
        double targetDistance = d - pos;

        arm_motors.setTargetDistance(targetDistance);
    }
}
