package com.pac_man.characters.Ghost.Chasers;

import com.pac_man.characters.Geometry.Direction;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Ghost.IChase;

public class PinkyChaser implements IChase{

    @Override
    public Position chase(Position targetPosition, Direction targetDirection, Position chaserPosition) {
        switch (targetDirection) {
            case UP:
                return new Position(targetPosition.getX() - 4, targetPosition.getY() - 4);
            case DOWN:
                return new Position(targetPosition.getX(), targetPosition.getY() + 4);
            case LEFT:
                return new Position(targetPosition.getX() - 4, targetPosition.getY());
            case RIGHT:
                return new Position(targetPosition.getX() + 4, targetPosition.getY());
            default:
                return targetPosition;
        }
    }
    
}
