package com.pac_man.characters.Pacman;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pac_man.characters.Pacman.Pacman;
import com.pac_man.characters.Geometry.Direction;
import com.pac_man.characters.Geometry.Position;



public class PacmanTest {

    /**private Pacman pacman;
    private TestKeyboardListener testKeyboardListener;

    
    static class TestKeyboardListener extends KeyboardListener {
        private List<String> inputs = new ArrayList<>();

        void setInputs(List<String> inputs) {
            this.inputs = inputs;
        }

        @Override
        public List<String> listen() {
            return inputs;
        }
    }

    @BeforeEach
    void setUp() {
        testKeyboardListener = new TestKeyboardListener();
        pacman = new Pacman(new Position(0, 0), testKeyboardListener);
    }

    @Test
    void testInitialLives() {
        assertEquals(3, pacman.amountOfLives);
    }

    @Test
    void testHit() {
        pacman.hit();
        assertEquals(2, pacman.amountOfLives);

        pacman.hit();
        assertEquals(1, pacman.amountOfLives);

        pacman.hit();
        assertEquals(0, pacman.amountOfLives);
    }

    @Test
    void testMoveUp() {
        pacman.up();
        assertEquals(Direction.UP, pacman.getDirection());
        assertEquals(new Position(0, -1), pacman.getPosition());
    }

    @Test
    void testMoveDown() {
        pacman.down();
        assertEquals(Direction.DOWN, pacman.getDirection());
        assertEquals(new Position(0, 1), pacman.getPosition());
    }

    @Test
    void testMoveLeft() {
        pacman.left();
        assertEquals(Direction.LEFT, pacman.getDirection());
        assertEquals(new Position(-1, 0), pacman.getPosition());
    }

    @Test
    void testMoveRight() {
        pacman.right();
        assertEquals(Direction.RIGHT, pacman.getDirection());
        assertEquals(new Position(1, 0), pacman.getPosition());
    }

    @Test
    void testNotifySubscriberUp() {
        testKeyboardListener.setInputs(List.of("UP"));
        pacman.notifySubscriber();
        assertEquals(Direction.UP, pacman.getDirection());
        assertEquals(new Position(0, -1), pacman.getPosition());
    }

    @Test
    void testNotifySubscriberDown() {
        testKeyboardListener.setInputs(List.of("DOWN"));
        pacman.notifySubscriber();
        assertEquals(Direction.DOWN, pacman.getDirection());
        assertEquals(new Position(0, 1), pacman.getPosition());
    }

    @Test
    void testNotifySubscriberLeft() {
        testKeyboardListener.setInputs(List.of("LEFT"));
        pacman.notifySubscriber();
        assertEquals(Direction.LEFT, pacman.getDirection());
        assertEquals(new Position(-1, 0), pacman.getPosition());
    }

    @Test
    void testNotifySubscriberRight() {
        testKeyboardListener.setInputs(List.of("RIGHT"));
        pacman.notifySubscriber();
        assertEquals(Direction.RIGHT, pacman.getDirection());
        assertEquals(new Position(1, 0), pacman.getPosition());
    }**/

}
