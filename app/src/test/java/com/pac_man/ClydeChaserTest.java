package com.pac_man;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.pac_man.characters.Geometry.Direction;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Ghost.Chasers.ClydeChaser;

public class ClydeChaserTest {

    @Test
    public void testChase() {
        ClydeChaser chaser = new ClydeChaser();
        Position targetPosition = new Position(10, 10);
        Position chaserPosition = new Position(1, 1);
        Direction targetDirection = Direction.UP;

        Position result = chaser.chase(targetPosition, targetDirection, chaserPosition);
        assertEquals(new Position(10, 10), result);

        chaserPosition = new Position(5, 5);
        result = chaser.chase(targetPosition, targetDirection, chaserPosition);
        assertEquals(new Position(0, 0), result);
    }
}
