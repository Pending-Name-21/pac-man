package com.pac_man.characters.Ghost;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bridge.processinputhandler.listeners.KeyboardListener;
import com.bridge.renderHandler.sprite.Coord;
import com.bridge.renderHandler.sprite.Size;
import com.bridge.renderHandler.sprite.Sprite;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Ghost.Chasers.BlinkyChaser;
import com.pac_man.characters.Ghost.Chasers.ClydeChaser;
import com.pac_man.characters.Ghost.Chasers.InkyChaser;
import com.pac_man.characters.Ghost.Chasers.PinkyChaser;
import com.pac_man.characters.Pacman.Pacman;

public class GhostTest {
    Ghost ghost;
    Pacman pacman;
    Sprite sprite;

    @BeforeEach
    void setUP(){
        pacman = new Pacman(new Position(5, 5), new KeyboardListener());
        sprite = new Sprite(new Coord(0, 0), new Size(1.0,1.0), Paths.get(""));
        ghost = new Ghost(new Position(0, 0), sprite, pacman, new BlinkyChaser());
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
        ghost = new Ghost(new Position(0, 0),sprite, pacman, new InkyChaser());
        Position current = ghost.getPosition();
        pacman.down();
        ghost.chase();
        Position chaseAfter = ghost.getPosition();
        
        assertNotEquals(current.getX(), chaseAfter.getX());
        assertNotEquals(current.getX(), chaseAfter.getY());

        assertEquals(chaseAfter.getX(), 5);
        assertEquals(chaseAfter.getY(), 8);   
    }

    @Test
    void testChaseClydeBehaviour1() {
        ghost = new Ghost(new Position(4, 5),sprite, pacman, new ClydeChaser());
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
        ghost = new Ghost(new Position(0, 0),sprite, pacman, new ClydeChaser());
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
        ghost = new Ghost(new Position(0, 0),sprite, pacman, new PinkyChaser());
        Position current = ghost.getPosition();
        pacman.up();
        ghost.chase();
        Position chaseAfter = ghost.getPosition();
        
        assertNotEquals(current.getX(), chaseAfter.getX());

        assertEquals(chaseAfter.getX(), 1);
        assertEquals(chaseAfter.getY(), 0);   
    }

    @Test
    void testFlee() {
        int x = ghost.getPosition().getX();
        int y = ghost.getPosition().getY();
        ghost.flee();
        if (x == ghost.getPosition().getX())assertNotEquals(y, ghost.getPosition().getY());    
        else assertNotEquals(x, ghost.getPosition().getX());
    }
}
