package com.pac_man;

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
import com.pac_man.Map.WallBlock;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Pacman.Pacman;

public class WallBlockTest {
    private WallBlock wallBlock;
    private Sprite sprite;

    @BeforeEach
    void setUp() {
        sprite = new Sprite(new Coord(0, 0), new Size(1, 1), Paths.get("path/to/wallblock.png"));
        wallBlock = new WallBlock(sprite);
    }

    @Test
    void testCanEnter() {
        assertFalse(wallBlock.canEnter());
    }

    @Test
    void testGetSprite() {
        assertEquals(sprite, wallBlock.getSprite());
    }

    @Test
    void testExit() {
        Body body = new Body("TestBody", new Pacman(new Position(0, 0), new KeyboardListener()));
        wallBlock.exit(body);
        assertTrue(sprite.isHidden());
    }
}
