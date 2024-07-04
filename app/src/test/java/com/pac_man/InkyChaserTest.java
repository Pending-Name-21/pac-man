package com.pac_man;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.pac_man.characters.Geometry.Direction;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Ghost.Chasers.InkyChaser;

public class InkyChaserTest {

    @Test
    public void testChase() {
        InkyChaser chaser = new InkyChaser();
        Position targetPosition = new Position(10, 10);
        Position chaserPosition = new Position(1, 1);
        
        Position result = chaser.chase(targetPosition, Direction.UP, chaserPosition);
        assertEquals(new Position(8, 8), result);

        result = chaser.chase(targetPosition, Direction.DOWN, chaserPosition);
        assertEquals(new Position(10, 12), result);

        result = chaser.chase(targetPosition, Direction.LEFT, chaserPosition);
        assertEquals(new Position(8, 10), result);

        result = chaser.chase(targetPosition, Direction.RIGHT, chaserPosition);
        assertEquals(new Position(12, 10), result);
    }
}
