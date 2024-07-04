package com.pac_man.characters.Ghost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pac_man.characters.Geometry.Direction;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Ghost.Chasers.ClydeChaser;


public class ClydeChaserTest {

    private ClydeChaser clydeChaser;

    @BeforeEach
    public void setUp() {
        clydeChaser = new ClydeChaser();
    }

    @Test
    public void testChaseWhenDistanceGreaterThanTarget() {
        Position targetPosition = new Position(10, 10);
        Position chaserPosition = new Position(0, 0);
        Position expectedPosition = targetPosition;

        Position result = clydeChaser.chase(targetPosition, Direction.RIGHT, chaserPosition);

        assertEquals(expectedPosition, result);
    }

    @Test
    public void testChaseWhenDistanceEqualToTarget() {
        Position targetPosition = new Position(4, 4);
        Position chaserPosition = new Position(0, 4);
        Position expectedPosition = new Position(0, 0);

        Position result = clydeChaser.chase(targetPosition, Direction.RIGHT, chaserPosition);

        assertEquals(expectedPosition, result);
    }

    @Test
    public void testChaseWhenDistanceLessThanTarget() {
        Position targetPosition = new Position(1, 1);
        Position chaserPosition = new Position(0, 0);
        Position expectedPosition = new Position(0, 0);
        Position result = clydeChaser.chase(targetPosition, Direction.RIGHT, chaserPosition);

        assertEquals(expectedPosition, result);
    }

    @Test
    public void testChaseWithDifferentPositions() {
        Position targetPosition = new Position(8, 3);
        Position chaserPosition = new Position(4, 4);
        Position expectedPosition = new Position(0, 0); 
        Position result = clydeChaser.chase(targetPosition, Direction.RIGHT, chaserPosition);

        assertEquals(expectedPosition, result);
    }

    @Test
    public void testChaseDefaultBehavior() {
        Position targetPosition = new Position(8, 8);
        Position chaserPosition = new Position(0, 0);
        Position expectedPosition = targetPosition;

        Position result = clydeChaser.chase(targetPosition, Direction.RIGHT, chaserPosition);

        assertEquals(expectedPosition, result);
    }

}