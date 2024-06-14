package com.pac_man;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.pac_man.Map.IBlock;
import com.pac_man.Map.Maze;
import com.pac_man.Map.SpawnBlock;
import com.pac_man.Map.StepBlock;
import com.pac_man.Map.WallBlock;



public class MazeTest {
    private Maze maze;

    @Test
    public void testPopulateFromFile() {
        maze = new Maze();
        maze.populateFromFile("app/src/main/Resources/general/Map.txt");

        IBlock[][] blocks = maze.getBlocks();
        assertEquals(21, blocks.length);
        assertEquals(19, blocks[0].length); 

        assertTrue(blocks[0][7] instanceof WallBlock);
        assertTrue(blocks[1][1] instanceof StepBlock);
        assertTrue(blocks[1][4] instanceof StepBlock);
        assertTrue(blocks[11][9] instanceof SpawnBlock);
        assertEquals("app/src/main/Resources/general/StepBlock.png", ((StepBlock)blocks[1][1]).getSprite().getPath());
        assertEquals("app/src/main/Resources/general/wall.png", ((WallBlock)blocks[2][2]).getSprite());

    }
}