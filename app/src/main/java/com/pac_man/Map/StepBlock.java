package com.pac_man.Map;
import java.util.ArrayList;
import java.util.List;

import com.bridge.renderHandler.sprite.Sprite;
import com.pac_man.Collisions.Body;
import com.pac_man.Collisions.ICollisionSubscriber;
import com.pac_man.Collisions.Nature;

public class StepBlock implements IBlock, ICollisionSubscriber {
    private Maze maze;
    private List<Body> bodies;
    private Sprite sprite;

    public StepBlock(Sprite sprite) {
        this.maze = new Maze();
        this.sprite = sprite;
        this.bodies = new ArrayList<>();
    }

    @Override
    public boolean canEnter() {
        return false; 
    }

    public Maze getMaze() {
        return maze;
    }

    public List<Body> getBodies() {
        return bodies;
    }

    public Sprite getSprite() {
        return sprite;
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
    
    private void checkCollision() {
        if (bodies.size() > 1) {
            String[] bodyIdentifiers = bodies.stream().map(Body::getIdentifier).toArray(String[]::new);
            for (Body body : bodies) {
                body.getElement().handleCollision(bodyIdentifiers, Nature.WITH);
            }
        }
    }

    @Override
    public void handleCollision(String[] bodies, Nature nature) {        
        System.out.println("Collision detected in StepBlock!");
    }

}
