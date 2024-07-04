package com.pac_man.characters.Ghost.Chasers;

import com.pac_man.characters.Geometry.Direction;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Ghost.IChase;

public class InkyChaser implements IChase{

    @Override
    public Position chase(Position targetPosition, Direction targetDirection, Position chaserPosition) {
        switch (targetDirection) {
            case UP:
                return new Position(targetPosition.getX() - 2, targetPosition.getY() - 2);
            case DOWN:
                return new Position(targetPosition.getX(), targetPosition.getY() + 2);
            case LEFT:
                return new Position(targetPosition.getX() - 2, targetPosition.getY());
            case RIGHT:
                return new Position(targetPosition.getX() + 2, targetPosition.getY());
            default:
                return targetPosition;
        }
    }
    
}
