package com.pac_man.characters.Ghost;

import com.pac_man.characters.Tools.Direction;
import com.pac_man.characters.Tools.Position;

public class ClydeChaser implements IChase{
    private static final int DISTANCE_TARGET = 8;
    private static final Position CORNER_TARGET = new Position(0, 0);

    @Override
    public Position chase(Position targetPosition, Direction targetDirection, Position chaserPosition) {
        
        int distance = Math.abs(targetPosition.getX() - chaserPosition.getY()) + Math.abs(targetPosition.getY() - chaserPosition.getX());
        if (distance > DISTANCE_TARGET) {
            return targetPosition;
        }
        return CORNER_TARGET;
    }
    
}
