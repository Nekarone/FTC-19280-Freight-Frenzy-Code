package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandBase;

public class RotateArm extends CommandBase{
    private final Arm m_arm;
    private final double arm_spd;

    public RotateArm(Arm HULKSMASH, double spd){
        m_arm = HULKSMASH;
        arm_spd = spd;
        addRequirements(m_arm);

    }

    @Override
    public void initialize(){
        m_arm.runMotors(arm_spd);
    }

    @Override
    public void execute(){}

    @Override
    public boolean isFinished(){
        m_arm.stopMotors();
        return true;
    }
}
