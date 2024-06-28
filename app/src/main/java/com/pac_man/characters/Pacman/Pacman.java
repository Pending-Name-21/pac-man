package com.pac_man.characters.Pacman;

import java.util.List;

import com.bridge.processinputhandler.listeners.KeyboardListener;
import com.bridge.updatehandler.IUpdateSubscriber;
import com.pac_man.Collectables.Sphere;
import com.pac_man.Collisions.ICollisionSubscriber;
import com.pac_man.Collisions.Nature;
import com.pac_man.characters.ACharacter;
import com.pac_man.characters.Geometry.Direction;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Score.Score;
import com.pac_man.characters.Utils.Sprite;

/**
 * Represents the Pacman character in the game.
 */
public class Pacman extends ACharacter implements  ICollisionSubscriber, IUpdateSubscriber{
    Sprite sprite;
    int amountOfLives;
    private boolean hasPowerSphere;
    private Direction direction;
    private KeyboardListener keyboardListener;
    private int consecutiveGhostEaten;
    private Score score;


    /**
     * Constructs a Pacman instance with the specified spawn position, sprite, and keyboard listener.
     *
     * @param spawnPosition the initial position of Pacman
     * @param sprite the sprite representing Pacman
     * @param keyboardListener the keyboard listener for capturing input events
     */
    public Pacman(Position spawnPosition, Sprite sprite, KeyboardListener keyboardListener) {
        super(spawnPosition);
        this.sprite = sprite;
        this.amountOfLives = 3;
        this.hasPowerSphere = false;
        this.keyboardListener = keyboardListener;
        this.score = new Score(0);
        this.consecutiveGhostEaten = 0;
    }

    public void setPowerSphere(boolean  _hasPowerSphere) {
        this.hasPowerSphere = _hasPowerSphere;
        if (!hasPowerSphere) {
            this.consecutiveGhostEaten = 0;
        }
    }

    /**
     * Reduces Pacman's lives by one. If lives reach zero, triggers game over logic. Otherwise, triggers respawn logic.
     */
    public void hit() {
        this.amountOfLives--;
        spawn();
    }


    /**
     * Moves Pacman up and updates the sprite and direction.
     */
    public void up() {
        this.sprite = Sprite.UP;
        this.direction = Direction.UP;
        move(Direction.UP);
    }

    /**
     * Moves Pacman down and updates the sprite and direction.
     */
    public void down() {
        this.sprite = Sprite.DOWN;
        this.direction = Direction.DOWN;
        move(Direction.DOWN);
    }

    /**
     * Moves Pacman left and updates the sprite and direction.
     */
    public void left() {
        this.sprite = Sprite.LEFT;
        this.direction = Direction.LEFT;
        move(Direction.LEFT);
    }

    /**
     * Moves Pacman right and updates the sprite and direction.
     */
    public void right() {
        this.sprite = Sprite.RIGHT;
        this.direction = Direction.RIGHT;
        move(Direction.RIGHT);
    }

    /**
     * Moves Pacman in the specified direction.
     *
     * @param direction the direction to move Pacman
     */
    private void move(Direction direction) {
        Position currentPosition = this.getPosition();
        Position newPosition = moveInDirection(currentPosition, direction);
        this.setPosition(newPosition);
    }


    /**
     * Calculates the new position based on the current position and the specified direction.
     *
     * @param currentPosition the current position of Pacman
     * @param direction the direction to move Pacman
     * @return the new position after moving in the specified direction
     */
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
    
    /**
     * Returns the current direction Pacman is facing.
     *
     * @return the current direction of Pacman
     */
    public Direction getDirection()
    {
        return this.direction;
    }

    /**
     * Updates Pacman's state based on the keyboard input events.
     */
    @Override
    public void notifySubscriber() {
        List<String> inputs = keyboardListener.listen();
        for (String input : inputs) {
            switch (input) {
                case "UP":
                    up();
                    break;
                case "DOWN":
                    down();
                    break;
                case "LEFT":
                    left();
                    break;
                case "RIGHT":
                    right();
                    break;
            }
        }
    }

     public Score getScore(){
        return this.score;
    }

    public void consumeSphere(){
        this.score.addPoints(Sphere.getValue());
    }

    public void consumeGhost() {
        hit();
        if (hasPowerSphere) {
            int ghostPoints = 15 * (1 << consecutiveGhostEaten);
            this.score.addPoints(ghostPoints);
            consecutiveGhostEaten++;
        }
    }

    @Override
    public void handleCollision(String[] bodies, Nature nature) {
        for (String body : bodies) {
            if (body.equals("Sphere") && nature == Nature.WITH) {
                consumeSphere();
            }
            else if (body.equals("Ghost") && nature == Nature.WITH && hasPowerSphere){
                consumeGhost();                    
            }
        }
    }

}
