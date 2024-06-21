package com.pac_man.characters.ScoreTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.bridge.processinputhandler.listeners.KeyboardListener;
import com.pac_man.Collisions.Nature;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Pacman.Pacman;
import com.pac_man.characters.Utils.Sprite;

public class PacmanGhostScoreTests {
    @Test
    public void testGhostConsumptionWithoutPowerSphere() {
        //define inputs and outputs
        String expectedScoreText =  "Score: 0";
        int expectedScoreAmount = 0;
        Position pos = new Position(0, 0);
        Pacman pacman = new Pacman(pos, Sprite.RIGHT, new KeyboardListener());
        
        //execute
        pacman.handleCollision(new String[]{"Ghost"}, Nature.WITH);
        int actualScoreAmount =pacman.getScore().getAmountPoints();
        String actualScoreText = pacman.getScore().getText().getText();

        //verify        
        assertEquals(expectedScoreAmount, actualScoreAmount);
        assertEquals(expectedScoreText, actualScoreText);
    }

    @Test
    public void testGhostSinleConsumptionWithPowerSphere() {
        //define inputs and outputs
        String expectedScoreText =  "Score: 15";
        int expectedScoreAmount = 15;
        Position pos = new Position(0, 0);
        Pacman pacman = new Pacman(pos, Sprite.RIGHT, new KeyboardListener());

        //execute
        pacman.setPowerSphere(true);
        pacman.handleCollision(new String[]{"Ghost"}, Nature.WITH);
        int actualScoreAmount =pacman.getScore().getAmountPoints();
        String actualScoreText = pacman.getScore().getText().getText();

        //verify
        assertEquals(expectedScoreAmount, actualScoreAmount);
        assertEquals(expectedScoreText, actualScoreText);
    }

    @Test
    public void testGhostDoubleConsumptionWithPowerSphere() {
        //define inputs and outputs
        String expectedScoreText =  "Score: 45";
        int expectedScoreAmount = 45;
        Position pos = new Position(0, 0);
        Pacman pacman = new Pacman(pos, Sprite.RIGHT, new KeyboardListener());

        //execute
        pacman.setPowerSphere(true);
        pacman.handleCollision(new String[]{"Ghost", "Ghost"}, Nature.WITH);
        int actualScoreAmount =pacman.getScore().getAmountPoints();
        String actualScoreText = pacman.getScore().getText().getText();

        //verify
        assertEquals(expectedScoreAmount, actualScoreAmount);
        assertEquals(expectedScoreText, actualScoreText);
    }

    @Test
    public void testGhostTripleConsumptionWithPowerSphere() {
        //define inputs and outputs
        String expectedScoreText =  "Score: 105";
        int expectedScoreAmount = 105;
        Position pos = new Position(0, 0);
        Pacman pacman = new Pacman(pos, Sprite.RIGHT, new KeyboardListener());

        //execute
        pacman.setPowerSphere(true);
        pacman.handleCollision(new String[]{"Ghost", "Ghost", "Ghost"}, Nature.WITH);
        int actualScoreAmount =pacman.getScore().getAmountPoints();
        String actualScoreText = pacman.getScore().getText().getText();

        //verify
        assertEquals(expectedScoreAmount, actualScoreAmount);
        assertEquals(expectedScoreText, actualScoreText);
    }

    @Test
    public void testGhostMultipleConsumptionWithPowerSphere() {
        //define inputs and outputs
        String expectedScoreText =  "Score: 225";
        int expectedScoreAmount = 225;
        Position pos = new Position(0, 0);
        Pacman pacman = new Pacman(pos, Sprite.RIGHT, new KeyboardListener());

        //execute
        pacman.setPowerSphere(true);
        pacman.handleCollision(new String[]{"Ghost", "Ghost", "Ghost", "Ghost"}, Nature.WITH);
        int actualScoreAmount =pacman.getScore().getAmountPoints();
        String actualScoreText = pacman.getScore().getText().getText();

        //verify
        assertEquals(expectedScoreAmount, actualScoreAmount);
        assertEquals(expectedScoreText, actualScoreText);
    }


    @Test
    public void testPowerSphereReset() {
        //define inputs and outputs
        String expectedScoreText =  "Score: 60";
        int expectedScoreAmount = 60;
        Position pos = new Position(0, 0);
        Pacman pacman = new Pacman(pos, Sprite.RIGHT, new KeyboardListener());

        pacman.setPowerSphere(true);
        pacman.handleCollision(new String[]{"Ghost"}, Nature.WITH);
        pacman.handleCollision(new String[]{"Ghost"}, Nature.WITH);
        pacman.setPowerSphere(false);
        pacman.setPowerSphere(true);
        pacman.handleCollision(new String[]{"Ghost"}, Nature.WITH);
        int actualScoreAmount =pacman.getScore().getAmountPoints();
        String actualScoreText = pacman.getScore().getText().getText();
    
        //verify
        assertEquals(expectedScoreAmount, actualScoreAmount);
        assertEquals(expectedScoreText, actualScoreText);
    }
}
