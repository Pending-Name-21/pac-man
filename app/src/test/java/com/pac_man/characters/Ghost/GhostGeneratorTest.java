package com.pac_man.characters.Ghost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.bridge.renderHandler.builders.SpriteBuilder;
import com.bridge.renderHandler.repository.SpriteRepository;
import com.pac_man.characters.Pacman.Pacman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pac_man.Map.IBlock;
import com.pac_man.Map.Maze;
import com.pac_man.Map.TestingBlock;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Geometry.Tuple;

public class GhostGeneratorTest {
    private GhostGenerator ghostGenerator;
    private Maze maze;

    @BeforeEach
    void setUp(){
        SpriteRepository spriteRepository = new SpriteRepository();
        SpriteBuilder spriteBuilder = new SpriteBuilder(spriteRepository);
        ghostGenerator = new GhostGenerator(spriteBuilder, "", new Pacman(new Position(1,1)));
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
