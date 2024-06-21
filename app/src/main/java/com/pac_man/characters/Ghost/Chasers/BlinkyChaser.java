package com.pac_man.characters.Ghost;

import com.pac_man.characters.Geometry.Direction;
import com.pac_man.characters.Geometry.Position;

public class BlinkyChaser implements IChase{

    @Override
    public Position chase(Position targetPosition, Direction targetDirection, Position chaserPosition){
        return targetPosition;
    }

}
