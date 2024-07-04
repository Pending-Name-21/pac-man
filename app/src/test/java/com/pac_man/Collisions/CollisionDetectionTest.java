package com.pac_man.Collisions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CollisionDetectionTest {
    private CollisionHandler collisionHandler;
    private Body body1;
    private Body body2;
    private TestCollisionSubscriber subscriber;

    @BeforeEach
    void setUp() {
        collisionHandler = new CollisionHandler();
        body1 = new Body("body1", null);
        body2 = new Body("body2", null);
        subscriber = new TestCollisionSubscriber();
        collisionHandler.addSubscriber(subscriber);
    }

    @Test
    void testBodyCreation() {
        assertNotNull(body1);
        assertNotNull(body2);
        assertEquals("body1", body1.getIdentifier());
        assertEquals("body2", body2.getIdentifier());
    }

    @Test
    void testCollisionHandlerAddSubscriber() {
        assertEquals(1, collisionHandler.subscribers.size());
        assertTrue(collisionHandler.subscribers.contains(subscriber));
    }

    @Test
    void testHandleCollision() {
        String[] bodies = new String[] {"body1", "body2"};
        Nature nature = Nature.WITH;
        collisionHandler.handleCollision(bodies, nature);
        assertTrue(subscriber.wasCollisionHandled);
        assertEquals(bodies, subscriber.bodies);
        assertEquals(nature, subscriber.nature);
    }

    @Test
    void testHandleCollisionMultipleSubscribers() {
        TestCollisionSubscriber subscriber2 = new TestCollisionSubscriber();
        collisionHandler.addSubscriber(subscriber2);
        String[] bodies = new String[] {"body1", "body2"};
        Nature nature = Nature.WITH;
        collisionHandler.handleCollision(bodies, nature);
        assertTrue(subscriber.wasCollisionHandled);
        assertTrue(subscriber2.wasCollisionHandled);
        assertEquals(bodies, subscriber.bodies);
        assertEquals(nature, subscriber.nature);
        assertEquals(bodies, subscriber2.bodies);
        assertEquals(nature, subscriber2.nature);
    }

    static class TestCollisionSubscriber implements ICollisionSubscriber {
        boolean wasCollisionHandled = false;
        String[] bodies;
        Nature nature;

        @Override
        public void handleCollision(String[] bodies, Nature nature) {
            wasCollisionHandled = true;
            this.bodies = bodies;
            this.nature = nature;
        }
    }

    
}