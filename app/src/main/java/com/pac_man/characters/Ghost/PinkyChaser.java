package com.pac_man.characters.Ghost;

import com.pac_man.characters.Tools.Direction;
import com.pac_man.characters.Tools.Position;

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
