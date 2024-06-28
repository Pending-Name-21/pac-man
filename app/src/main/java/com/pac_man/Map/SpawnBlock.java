package com.pac_man.Map;


import java.util.ArrayList;
import java.util.List;

import com.bridge.renderHandler.sprite.Sprite;
import com.pac_man.Collisions.Body;
import com.pac_man.Collisions.ICollisionSubscriber;
import com.pac_man.Collisions.Nature;

public class SpawnBlock implements IBlock {
    private Sprite sprite;
    private List<Body> bodies;

    public SpawnBlock(Sprite sprite) {
        this.sprite = sprite;
        this.bodies= new ArrayList<>();
    }

    @Override
    public boolean canEnter() {
        return true; 
    }
    
    public List<Body> getBodies() {
        return bodies;
    }

    public void enter(Body body) {
        bodies.add(body);
        for (Body otherBody : bodies) {
            if (!otherBody.equals(body) && otherBody.getElement() instanceof ICollisionSubscriber) {
                ICollisionSubscriber subscriber = (ICollisionSubscriber) otherBody.getElement();
                subscriber.handleCollision(new String[]{body.getIdentifier()}, Nature.BY);
            }
        }
    }

    public void exit(Body body) {
        bodies.remove(body);
    }

    public Sprite getSprite() {
        return sprite;
    }
}
