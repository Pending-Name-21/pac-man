package com.pac_man.characters.Ghost;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pac_man.characters.Geometry.Direction;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Ghost.Chasers.InkyChaser;

public class InkyChaserTest {

    Position targetPosition;
    Position chaserPosition;
    InkyChaser chaser;


    @BeforeEach
    void setUP(){
         targetPosition = new Position(10, 10);
         chaserPosition = new Position(5, 5);
         chaser = new InkyChaser();
    }


    @Test
    public void testChaseUp() {
        Direction targetDirection = Direction.UP;
        Position newPosition = chaser.chase(targetPosition, targetDirection, chaserPosition);
        assertEquals(new Position(8, 8), newPosition);
    }

    @Test
    public void testChaseDown() {
        Direction targetDirection = Direction.DOWN;
        Position newPosition = chaser.chase(targetPosition, targetDirection, chaserPosition);
        assertEquals(new Position(10, 12), newPosition);
    }

    @Test
    public void testChaseLeft() {
        Direction targetDirection = Direction.LEFT;
        Position newPosition = chaser.chase(targetPosition, targetDirection, chaserPosition);
        assertEquals( new Position(8, 10), newPosition);
    }

    @Test
    public void testChaseRight() {
        Direction targetDirection = Direction.RIGHT;
        Position newPosition = chaser.chase(targetPosition, targetDirection, chaserPosition);
        assertEquals(new Position(12, 10), newPosition);
    }
}
