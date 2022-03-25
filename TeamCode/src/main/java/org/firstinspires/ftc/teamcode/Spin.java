package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandBase;

import java.util.function.DoubleSupplier;

public class Spin extends CommandBase{
    private final SpinWheel m_spinwheel;
    private final int direction;
    public Spin(SpinWheel sWheel, int d){
        m_spinwheel = sWheel;
        direction = d;

        addRequirements(m_spinwheel);
    }

    @Override
    public void execute(){
        if(direction == 1) m_spinwheel.spin();
        else if (direction == -1) m_spinwheel.spin_back();

    }

}
