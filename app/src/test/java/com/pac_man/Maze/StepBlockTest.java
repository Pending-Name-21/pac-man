package com.pac_man.Maze;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bridge.processinputhandler.listeners.KeyboardListener;
import com.bridge.renderHandler.sprite.Coord;
import com.bridge.renderHandler.sprite.Size;
import com.bridge.renderHandler.sprite.Sprite;
import com.pac_man.Collisions.Body;
import com.pac_man.Collisions.Nature;
import com.pac_man.Map.StepBlock;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Pacman.Pacman;

public class StepBlockTest {
    private StepBlock stepBlock;
    private Sprite sprite;

    @BeforeEach
    void setUp() {
        sprite = new Sprite(new Coord(0, 0), new Size(1, 1), Paths.get(""));
        stepBlock = new StepBlock(sprite);
    }

    @Test
    void testCanEnter() {
        assertFalse(stepBlock.canEnter());
        Body body = new Body("TestBody", new Pacman(new Position(0, 0), new KeyboardListener()));
        stepBlock.enter(body);
        assertFalse(stepBlock.canEnter());
        
        stepBlock.exit(body);
        assertFalse(stepBlock.canEnter());
    }

    @Test
    void testGetSprite() {
        assertEquals(sprite, stepBlock.getSprite());
    }

    @Test
    void testEnterAndExit() {
        Body body = new Body("TestBody", new Pacman(new Position(0, 0), new KeyboardListener()));
        stepBlock.enter(body);
        assertTrue(stepBlock.getBodies().contains(body));
        stepBlock.exit(body);
        assertFalse(stepBlock.getBodies().contains(body));
    }

    @Test
    void testHandleCollision() {
        Body body = new Body("TestBody", new Pacman(new Position(0, 0), new KeyboardListener()));
        stepBlock.enter(body);
        stepBlock.handleCollision(new String[]{"TestBody"}, Nature.WITH);
        assertTrue(stepBlock.getBodies().contains(body));
    }

    @Test
    void testMultipleBodies() {
        Body body1 = new Body("TestBody1", new Pacman(new Position(0, 0), new KeyboardListener()));
        Body body2 = new Body("TestBody2", new Pacman(new Position(1, 1), new KeyboardListener()));

        stepBlock.enter(body1);
        stepBlock.enter(body2);

        assertTrue(stepBlock.getBodies().contains(body1));
        assertTrue(stepBlock.getBodies().contains(body2));

        stepBlock.exit(body1);
        assertFalse(stepBlock.getBodies().contains(body1));
        assertTrue(stepBlock.getBodies().contains(body2));

        stepBlock.exit(body2);
        assertFalse(stepBlock.getBodies().contains(body2));
    }
}
