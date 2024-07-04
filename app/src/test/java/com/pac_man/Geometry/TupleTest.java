package com.pac_man.Geometry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.pac_man.characters.Geometry.Tuple;

public class TupleTest {

    @Test
    public void testTupleInitialization() {
        Tuple<Integer, String> tuple = new Tuple<>(1, "value");
        assertEquals(1, tuple.x);
        assertEquals("value", tuple.y);
    }
}
