package com.pac_man.Collectables;

import com.pac_man.Collisions.ICollisionSubscriber;
import com.pac_man.Collisions.Nature;

public class Sphere implements ICollisionSubscriber{
    private static final int VALUE = 10;
    public static int getValue() {
        return VALUE;
    }
    @Override
    public void handleCollision(String[] bodies, Nature nature) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleCollision'");
    }

}
