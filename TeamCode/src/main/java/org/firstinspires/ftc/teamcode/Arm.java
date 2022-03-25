package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor.Encoder;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class Arm extends SubsystemBase{
    public Motor arm_motor_1, arm_motor_2;

    public Arm(Motor am1, Motor am2){
        arm_motor_1 = am1;
        arm_motor_2 = am2;

        //Set the mode of the Motor to Position Control
        arm_motor_1.setRunMode(Motor.RunMode.PositionControl);
        arm_motor_2.setRunMode(Motor.RunMode.PositionControl);

        //Set position of position coefficient
    }
}
