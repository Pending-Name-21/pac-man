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
import com.pac_man.Map.SpawnBlock;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Pacman.Pacman;

public class SpawnBlockTest {
    private SpawnBlock spawnBlock;
    private Sprite sprite;

    @BeforeEach
    void setUp() {
        sprite = new Sprite(new Coord(0, 0), new Size(1, 1), Paths.get(""));
        spawnBlock = new SpawnBlock(sprite);
    }

    @Test
    void testCanEnter() {
        assertTrue(spawnBlock.canEnter());
    }

    @Test
    void testGetSprite() {
        assertEquals(sprite, spawnBlock.getSprite());
    }

    @Test
    void testEnterAndExit() {
        Body body = new Body("TestBody", new Pacman(new Position(0, 0), new KeyboardListener()));
        spawnBlock.enter(body);
        assertTrue(spawnBlock.getBodies().contains(body));

        spawnBlock.exit(body);
        assertFalse(spawnBlock.getBodies().contains(body));
    }
}

