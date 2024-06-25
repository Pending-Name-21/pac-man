package com.pac_man.Collectables;

import com.pac_man.Collisions.Body;
import com.pac_man.Collisions.ICollisionSubscriber;
import com.pac_man.Collisions.Nature;
import com.pac_man.Map.IBlock;
import com.bridge.renderHandler.sprite.Sprite;
import com.bridge.renderHandler.sprite.Sprite;
import com.pac_man.Collisions.ICollisionSubscriber;
import com.pac_man.Collisions.Nature;
import com.pac_man.characters.Geometry.Position;

public class Sphere implements ICollisionSubscriber {
    
    private static final int VALUE = 10;
    private  IBlock block;
    private Sprite sprite;
    private Position position;
    private boolean isConsume;

    public Sphere(Sprite sprite, Position position) {
        this.sprite = sprite;
        this.position = position;
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

    public static int getValue() {
        return VALUE;
    }

    public void consumeSphere() {
        isConsume = true;
    }

    @Override
    public void handleCollision(String[] bodies, Nature nature) {
        for (String body : bodies) {
            if (body.equals("Sphere") && nature == Nature.BY) {
                block.exit(new Body(body,this));
            }
        }
    }

}
