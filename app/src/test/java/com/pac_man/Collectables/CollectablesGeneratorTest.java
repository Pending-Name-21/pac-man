package com.pac_man.Collectables;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pac_man.Map.IBlock;
import com.pac_man.Map.Maze;
import com.pac_man.Map.TestingBlock;
import com.pac_man.characters.Geometry.Position;

public class CollectablesGeneratorTest {

     private CollectablesGenerators generators;
    private Maze maze;
    private List<Position> emptyPositions;

    @BeforeEach
    public void setUp() {
        generators = new CollectablesGenerators();
        IBlock[][] blocks = {{new TestingBlock(true), new TestingBlock(true), new TestingBlock(true)},{new TestingBlock(true), new TestingBlock(true), new TestingBlock(true)},{new TestingBlock(true), new TestingBlock(true), new TestingBlock(true)}};
        maze= new Maze(blocks);
        emptyPositions = new ArrayList<>();
        for (int i = 0; i < 250; i++) {
            emptyPositions.add(new Position(i, i));
        }
    }

    @Test
    public void testPopulate() {
        generators.populate(maze);

        assertEquals(9, generators.getSphereList().size(), "Should have 240 spheres");
        assertEquals(0, generators.getPowerSphereList().size(), "Should have 4 power spheres");
    }
}
