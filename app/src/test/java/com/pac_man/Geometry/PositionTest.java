package com.pac_man.Geometry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

import com.pac_man.characters.Geometry.Position;

public class PositionTest {

    @Test
    public void testPositionInitialization() {
        Position position = new Position(2, 3);
        assertEquals(2, position.getX());
        assertEquals(3, position.getY());
    }

    @Test
    public void testEquals() {
        Position pos1 = new Position(1, 2);
        Position pos2 = new Position(1, 2);
        Position pos3 = new Position(2, 3);
        assertEquals(pos1, pos2);
        assertNotEquals(pos1, pos3);
    }

    @Test
    public void testHashCode() {
        Position pos1 = new Position(1, 2);
        Position pos2 = new Position(1, 2);
        assertEquals(pos1.hashCode(), pos2.hashCode());
    }

    @Test
    public void testToString() {
        Position position = new Position(2, 3);
        assertEquals("Position{x=2, y=3}", position.toString());
    }
}
