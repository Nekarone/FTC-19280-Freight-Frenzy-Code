package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandBase;

public class grab extends CommandBase{
    private final grabber m_grabber;

    public grab(grabber g){
        m_grabber = g;
        addRequirements(m_grabber);
    }

    @Override
    public void initialize(){
        m_grabber.grabObject();
    }

    @Override
    public boolean isFinished(){
        return true;

    }}
