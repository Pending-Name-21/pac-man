package com.pac_man.characters.Ghost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.bridge.processinputhandler.listeners.KeyboardListener;
import com.pac_man.characters.Pacman.Pacman;
import com.pac_man.characters.Tools.Position;
import com.pac_man.characters.Tools.Sprite;
public class GhostTest {
    Ghost ghost;
    Pacman pacman;

    @BeforeEach
    void setUP(){
        pacman = new Pacman(new Position(5, 5), new Sprite(), new KeyboardListener());
        ghost = new Ghost(new Position(0, 0), new Sprite(), pacman, new BlinkyChaser());
    }

    @Test
    void testChaseBlinky() {
        Position current = ghost.getPosition();
        ghost.chase();
        Position chaseAfter = ghost.getPosition();
        
        assertNotEquals(current.getX(), chaseAfter.getX());
        assertNotEquals(current.getX(), chaseAfter.getY());

        assertEquals(chaseAfter.getX(), 5);
        assertEquals(chaseAfter.getY(), 5);   
    }

    @Test
    void testChaseInky() {
        ghost = new Ghost(new Position(0, 0), new Sprite(), pacman, new InkyChaser());
        Position current = ghost.getPosition();
        pacman.down();
        ghost.chase();
        Position chaseAfter = ghost.getPosition();
        
        assertNotEquals(current.getX(), chaseAfter.getX());
        assertNotEquals(current.getX(), chaseAfter.getY());

        assertEquals(chaseAfter.getX(), 5);
        assertEquals(chaseAfter.getY(), 7);   
    }

    @Test
    void testChaseClydeBehaviour1() {
        ghost = new Ghost(new Position(4, 5), new Sprite(), pacman, new ClydeChaser());
        Position current = ghost.getPosition();
        ghost.chase();
        Position chaseAfter = ghost.getPosition();
        
        assertNotEquals(current.getX(), chaseAfter.getX());
        assertNotEquals(current.getX(), chaseAfter.getY());

        assertEquals(chaseAfter.getX(), 0);
        assertEquals(chaseAfter.getY(), 0);
    }
    @Test
    void testChaseClydeBehaviour2() {
        ghost = new Ghost(new Position(0, 0), new Sprite(), pacman, new ClydeChaser());
        Position current = ghost.getPosition();
        ghost.chase();
        Position chaseAfter = ghost.getPosition();
        
        assertNotEquals(current.getX(), chaseAfter.getX());
        assertNotEquals(current.getX(), chaseAfter.getY());

        assertEquals(chaseAfter.getX(), 5);
        assertEquals(chaseAfter.getY(), 5);
    }
    @Test
    void testChasePinky() {
        ghost = new Ghost(new Position(0, 0), new Sprite(), pacman, new PinkyChaser());
        Position current = ghost.getPosition();
        pacman.up();
        ghost.chase();
        Position chaseAfter = ghost.getPosition();
        
        assertNotEquals(current.getX(), chaseAfter.getX());
        assertNotEquals(current.getX(), chaseAfter.getY());

        assertEquals(chaseAfter.getX(), 1);
        assertEquals(chaseAfter.getY(), 1);   
    }

    @Test
    void testFlee() {
        int x = ghost.getPosition().getX();
        int y = ghost.getPosition().getY();
        ghost.flee();

        //The conditinal here is because flee will randonmically change x or y to flee
        if (x == ghost.getPosition().getX())assertNotEquals(y, ghost.getPosition().getY());    
        else assertNotEquals(x, ghost.getPosition().getX());
    }
}
