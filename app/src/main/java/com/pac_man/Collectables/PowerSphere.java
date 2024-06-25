package com.pac_man.Collectables;

import com.bridge.renderHandler.sprite.Sprite;
import com.pac_man.Collisions.Nature;
import com.pac_man.characters.Geometry.Position;

public class PowerSphere extends APowerUp {

    private Position position;
    private Sprite sprite;
    private boolean isConsume;

    public PowerSphere(Sprite sprite, Position initPosition) {
        this.sprite = sprite;
        this.position = initPosition;
        isConsume = false;
    }

    public boolean getConsume() {
        return isConsume;
    }
    public Position getPosition() {
        return position;
    }
    public Sprite getSprite() {
        return sprite;
    }

    public void consumeSphere() {
        isConsume = true;
    }

    @Override
    public void handleCollision(String[] bodies, Nature nature) {
        for (String bodyP : bodies) {
            if (bodyP.equals("Pacman") && nature == Nature.WITH) {
                consumeSphere();
            }
        }
    }

    
}
