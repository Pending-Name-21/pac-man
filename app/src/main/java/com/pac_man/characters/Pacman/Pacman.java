package com.pac_man.characters.Pacman;

import com.pac_man.Collectables.Sphere;
import com.pac_man.Collisions.ICollisionSubscriber;
import com.pac_man.Collisions.Nature;
import com.pac_man.characters.ACharacter;
import com.pac_man.characters.Geometry.Direction;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Score.Score;
import com.pac_man.characters.Utils.Sprite;

public class Pacman extends ACharacter implements  ICollisionSubscriber{
    private Sprite sprite;
    private int amountOfLives;
    private boolean hasPowerSphere;
    private Direction direction;
    private Score score;

    public Pacman(Position spawnPosition, Sprite sprite) {
        super(spawnPosition);
        this.sprite = sprite;
        this.amountOfLives = 3;
        this.hasPowerSphere = false;
        this.score = new Score(0);
    }

    public void hit() {
        this.amountOfLives--;
        if (this.amountOfLives <= 0) {
            // Game over logic
        } else {
            // Respawn logic
        }
    }
    
    public void up() {
        this.sprite = Sprite.UP;
        this.direction = Direction.UP;
    }

    public void down() {
        this.sprite = Sprite.DOWN;
        this.direction = Direction.DOWN;
    }

    public void left() {
        this.sprite = Sprite.LEFT;
        this.direction = Direction.LEFT;
    }

    public void right() {
        this.sprite = Sprite.RIGHT;
        this.direction = Direction.RIGHT;
    }
    
    public Direction getDirection()
    {
        return this.direction;
    }

    public Score getScore(){
        return this.score;
    }
    public void consumeSphere(){
        this.score.addPoints(Sphere.getValue());
    }

    @Override
    public void handleCollision(String[] bodies, Nature nature) {
        for (String body : bodies) {
            if (body.equals("Sphere") && nature == Nature.WITH) {
                consumeSphere();
            }
        }
    }

}
