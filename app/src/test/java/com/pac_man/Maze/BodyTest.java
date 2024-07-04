package com.pac_man.Maze;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.pac_man.Collisions.Body;
import com.pac_man.Collisions.ICollisionSubscriber;
import com.pac_man.Collisions.Nature;

public class BodyTest {

    @Test
    public void testGetIdentifier() {
        ICollisionSubscriber subscriber = new ICollisionSubscriber() {
            @Override
            public void handleCollision(String[] bodies, Nature nature) {
            }
        };
        Body body = new Body("identifier1", subscriber);
        assertEquals("identifier1", body.getIdentifier());
    }

    @Test
    public void testGetElement() {
        ICollisionSubscriber subscriber = new ICollisionSubscriber() {
            @Override
            public void handleCollision(String[] bodies, Nature nature) {
            }
        };
        Body body = new Body("identifier1", subscriber);
        assertEquals(subscriber, body.getElement());
    }
}