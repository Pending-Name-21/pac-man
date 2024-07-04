package com.pac_man;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.pac_man.characters.Geometry.Direction;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Ghost.Chasers.PinkyChaser;

public class PinkyChaserTest {

    @Test
    public void testChase() {
        PinkyChaser chaser = new PinkyChaser();
        Position targetPosition = new Position(10, 10);
        Position chaserPosition = new Position(1, 1);
        
        Position result = chaser.chase(targetPosition, Direction.UP, chaserPosition);
        assertEquals(new Position(6, 6), result);

        result = chaser.chase(targetPosition, Direction.DOWN, chaserPosition);
        assertEquals(new Position(10, 14), result);

        result = chaser.chase(targetPosition, Direction.LEFT, chaserPosition);
        assertEquals(new Position(6, 10), result);

        result = chaser.chase(targetPosition, Direction.RIGHT, chaserPosition);
        assertEquals(new Position(14, 10), result);
    }
}
