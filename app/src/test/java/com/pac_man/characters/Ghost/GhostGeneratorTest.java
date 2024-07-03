package com.pac_man.characters.Ghost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pac_man.Map.IBlock;
import com.pac_man.Map.Maze;
import com.pac_man.Map.TestingBlock;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Geometry.Tuple;
import com.pac_man.characters.Ghost.Chasers.BlinkyChaser;

public class GhostGeneratorTest {
    private GhostGenerator ghostGenerator;
    private Maze maze;

    @BeforeEach
    void setUp(){
        ghostGenerator = new GhostGenerator();
        IBlock[][] blocks = {{new TestingBlock(true), new TestingBlock(true), new TestingBlock(true)},{new TestingBlock(true), new TestingBlock(true), new TestingBlock(true)},{new TestingBlock(true), new TestingBlock(true), new TestingBlock(true)}};
        maze= new Maze(blocks);
    }
    @Test
    void testPopulate() {
        ghostGenerator.populate(maze);

        List<Tuple<Ghost, Position>> ghostPositions = ghostGenerator.getGhostsPositions();

        assertEquals(4, ghostPositions.size());
        for (Tuple<Ghost, Position> tuple : ghostPositions) {
            assertTrue(tuple.x instanceof Ghost);
            assertTrue(tuple.y instanceof Position);
        }
    }

    @Test
    void testSpawnGhost() {
        Position position = new Position(1, 1);
        IChase chase = new BlinkyChaser();
        Ghost ghost = ghostGenerator.spawnGhost(position, chase);

        assertNotNull(ghost);
        assertEquals(position, ghost.getPosition());
        assertEquals(chase, ghost.getChaseBehaviour());
    }
}
