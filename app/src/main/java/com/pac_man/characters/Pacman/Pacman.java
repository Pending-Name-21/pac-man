package com.pac_man.characters.Pacman;

import com.pac_man.characters.ACharacter;
import com.pac_man.characters.Tools.Direction;
import com.pac_man.characters.Tools.Position;
import com.pac_man.characters.Tools.Sprite;

public class Pacman extends ACharacter{
    private Sprite sprite;
    private int amountOfLives;
    private boolean hasPowerSphere;
    private Direction direction;

    public Pacman(Position spawnPosition, Sprite sprite) {
        super(spawnPosition);
        this.sprite = sprite;
        this.amountOfLives = 3;
        this.hasPowerSphere = false;
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
}
