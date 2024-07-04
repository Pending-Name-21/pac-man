package com.pac_man.Maze;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pac_man.Map.IBlock;
import com.pac_man.Map.Maze;
import com.pac_man.Map.WallBlock;

public class MazeTest {
    private Maze maze;

    @BeforeEach
    void setUp() {
        maze = new Maze();
    }

    @Test
    void testMazeInitialization() {
        IBlock[][] blocks = maze.getBlocks();
        assertNotNull(blocks);
        assertEquals(21, blocks.length);
        assertEquals(19, blocks[0].length);
    }

    @Test
    void testPopulateFromFile() {
        String resourcePath = "app/src/main/java/com/pac_man/Resources/MazeElement/Map.txt";        
        maze.populateFromFile(resourcePath);

        IBlock[][] blocks = maze.getBlocks();
        assertTrue(blocks[0][0] instanceof WallBlock);
    }

}
