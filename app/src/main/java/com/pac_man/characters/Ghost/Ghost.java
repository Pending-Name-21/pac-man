package com.pac_man.characters.Ghost;



import com.pac_man.characters.ACharacter;
import com.pac_man.characters.Pacman.Pacman;
import com.pac_man.characters.Tools.Direction;
import com.pac_man.characters.Tools.Position;
import com.pac_man.characters.Tools.Sprite;
import java.util.Random;


public class Ghost extends ACharacter{
    private Sprite sprite;
    private Pacman target;
    private IChase chaseBehaviour;
    

    public Ghost(Position position, Sprite sprite, Pacman pacman, IChase chase)
    {
        super(position);
        this.sprite = sprite;
        this.target = pacman;
        this.chaseBehaviour = chase;
    }

    public Ghost(Position position, IChase chase)
    {
        super(position);
        this.chaseBehaviour = chase;
    }

    public void flee(){
        Direction[] directions = Direction.values();
        Direction radomDirection = directions[new Random().nextInt(directions.length)];
        this.setPosition(moveInDirection(getPosition(), radomDirection));
        
    }
    
    public void chase(){
        Position newPos = chaseBehaviour.chase(target.getPosition(), target.getDirection(), getPosition());
        this.setPosition(newPos);
    }

    private Position moveInDirection(Position currentPosition, Direction direction) {
        switch (direction) {
            case UP:
                return new Position(currentPosition.getX(), currentPosition.getY() - 1);
            case DOWN:
                return new Position(currentPosition.getX(), currentPosition.getY() + 1);
            case LEFT:
                return new Position(currentPosition.getX() - 1, currentPosition.getY());
            case RIGHT:
                return new Position(currentPosition.getX() + 1, currentPosition.getY());
            default:
                return currentPosition;
        }
    }
    public IChase getChaseBehaviour()
    {
        return chaseBehaviour;
    }
}
