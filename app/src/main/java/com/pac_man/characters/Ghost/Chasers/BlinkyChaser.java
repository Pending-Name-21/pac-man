package com.pac_man.characters.Ghost.Chasers;

import com.pac_man.characters.Geometry.Direction;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Ghost.IChase;

public class BlinkyChaser implements IChase{

    @Override
    public Position chase(Position targetPosition, Direction targetDirection, Position chaserPosition){
        return targetPosition;
    }

}
