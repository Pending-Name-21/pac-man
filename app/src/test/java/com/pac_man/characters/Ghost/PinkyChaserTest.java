package com.pac_man.characters.Ghost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pac_man.characters.Geometry.Direction;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Ghost.Chasers.PinkyChaser;

public class PinkyChaserTest {
    Position targetPosition;
    Position chaserPosition;
    PinkyChaser chaser;


    @BeforeEach
    void setUP(){
         targetPosition = new Position(10, 10);
         chaserPosition = new Position(5, 5);
         chaser = new PinkyChaser();
    }


    @Test
    public void testChaseUp() {
        Direction targetDirection = Direction.UP;
        Position newPosition = chaser.chase(targetPosition, targetDirection, chaserPosition);
        assertEquals(new Position(6, 6), newPosition);
    }

    @Test
    public void testChaseDown() {
        Direction targetDirection = Direction.DOWN;
        Position newPosition = chaser.chase(targetPosition, targetDirection, chaserPosition);
        assertEquals(new Position(10, 14), newPosition);
    }

    @Test
    public void testChaseLeft() {
        Direction targetDirection = Direction.LEFT;
        Position newPosition = chaser.chase(targetPosition, targetDirection, chaserPosition);
        assertEquals( new Position(6, 10), newPosition);
    }

    @Test
    public void testChaseRight() {
        Direction targetDirection = Direction.RIGHT;
        Position newPosition = chaser.chase(targetPosition, targetDirection, chaserPosition);
        assertEquals(new Position(14, 10), newPosition);
    }
}