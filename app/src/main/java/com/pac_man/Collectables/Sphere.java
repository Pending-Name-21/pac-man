package com.pac_man.Collectables;

import com.pac_man.Collisions.Body;
import com.pac_man.Collisions.ICollisionSubscriber;
import com.pac_man.Collisions.Nature;
import com.pac_man.Map.IBlock;
import com.bridge.renderHandler.sprite.Sprite;

public class Sphere implements ICollisionSubscriber{
    private static final int VALUE = 10;
    private  IBlock block;
    private Sprite sprite;
    public static int getValue() {
        return VALUE;
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
