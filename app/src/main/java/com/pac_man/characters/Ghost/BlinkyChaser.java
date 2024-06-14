package com.pac_man.characters.Ghost;

import com.pac_man.characters.Tools.Direction;
import com.pac_man.characters.Tools.Position;

public class BlinkyChaser implements IChase{

    @Override
    public Position chase(Position targetPosition, Direction targetDirection, Position chaserPosition){
        return targetPosition;
    }

}
