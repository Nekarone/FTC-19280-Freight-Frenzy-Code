package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class grabber extends SubsystemBase{
    public Servo grab_servo;

    public grabber(final HardwareMap hMap, final String name){
        grab_servo = hMap.get(Servo.class, name);
    }

    public void grabObject(){
        grab_servo.setPosition(0.5);
    }

    public void releaseObject(){
        grab_servo.setPosition(0);
    }
}
