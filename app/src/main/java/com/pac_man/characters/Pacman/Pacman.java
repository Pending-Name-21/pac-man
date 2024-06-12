package com.pac_man.characters.Pacman;

import com.pac_man.characters.ACharacter;
import com.pac_man.characters.Tools.Position;
import com.pac_man.characters.Tools.Sprite;

public class Pacman extends ACharacter{
    private Sprite sprite;
    private int amountOfLives;
    private boolean hasPowerSphere;

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
    }

    public void down() {
        this.sprite = Sprite.DOWN;
    }

    public void left() {
        this.sprite = Sprite.LEFT;
    }

    public void right() {
        this.sprite = Sprite.RIGHT;
    }
}
