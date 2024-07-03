package com.pac_man.characters.ScoreTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

//import com.bridge.processinputhandler.listeners.KeyboardListener;
import com.pac_man.Collisions.Nature;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Pacman.Pacman;

public class PacmanSphereScoreTests {
    /**@Test
    public void testInitialScore() {
        // define inputs and outputs
        String expectedScoreText =  "Score: 0";
        int expectedScoreAmount = 0;
        Position pos = new Position(0, 0);
        Pacman pacman = new Pacman(pos,new KeyboardListener());

        //execute
        int actualScoreAmount =pacman.getScore().getAmountPoints();
        String actualScoreText = pacman.getScore().getText().getText();

        //verify
        assertEquals(expectedScoreAmount, actualScoreAmount);
        assertEquals(expectedScoreText, actualScoreText);
    }

    @Test
    public void testScoreIncrease() {
        //definde inputs and outputs
        String expectedScoreText =  "Score: 10";
        int expectedScoreAmount = 10;
        Position pos = new Position(0, 0);
        Pacman pacman = new Pacman(pos, new KeyboardListener());

        //execute
        pacman.handleCollision(new String[]{"Sphere"}, Nature.WITH);
        int actualScoreAmount =pacman.getScore().getAmountPoints();
        String actualScoreText = pacman.getScore().getText().getText();

        //verify
        assertEquals(expectedScoreAmount, actualScoreAmount);
        assertEquals(expectedScoreText, actualScoreText);
    }

    @Test
    public void testMultipleSphereCollisions() {
        //define inputs and outputs
        String expectedScoreText =  "Score: 50";
        int expectedScoreAmount = 50;
        Position pos = new Position(0, 0);
        Pacman pacman = new Pacman(pos, new KeyboardListener());

        //execute
        pacman.handleCollision(new String[]{"Sphere", "Sphere", "Sphere", "Sphere", "Sphere"}, Nature.WITH);
        int actualScoreAmount =pacman.getScore().getAmountPoints();
        String actualScoreText = pacman.getScore().getText().getText();

        //verify
        assertEquals(expectedScoreAmount, actualScoreAmount);
        assertEquals(expectedScoreText, actualScoreText);
    }

    @Test
    public void testCollisionWithNonSphere() {
        //define inputs and outputs
        String expectedScoreText =  "Score: 0";
        int expectedScoreAmount = 0;
        Position pos = new Position(0, 0);
        Pacman pacman = new Pacman(pos, new KeyboardListener());

        //execute
        pacman.handleCollision(new String[]{"Wall"}, Nature.WITH);
        int actualScoreAmount =pacman.getScore().getAmountPoints();
        String actualScoreText = pacman.getScore().getText().getText();

        //verify
        assertEquals(expectedScoreAmount, actualScoreAmount);
        assertEquals(expectedScoreText, actualScoreText);
    }**/
}
