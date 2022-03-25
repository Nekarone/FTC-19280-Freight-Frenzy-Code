package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.Motor.Encoder;
import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class SpinWheel extends SubsystemBase{
    public Motor duck_motor;
    public double SPIN_SPEED;
    public SpinWheel(Motor d_motor, double spin_spd){
        duck_motor = d_motor;
        SPIN_SPEED = spin_spd;

        duck_motor.setRunMode(Motor.RunMode.RawPower);
    }

    public void spin(){
        duck_motor.set(SPIN_SPEED);
    }

    public void spin_back(){
        duck_motor.set(-SPIN_SPEED);
    }

}
