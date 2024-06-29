package com.pac_man;

import com.bridge.processinputhandler.listeners.KeyboardListener;
import com.bridge.renderHandler.sprite.Size;
import com.bridge.renderHandler.sprite.Sprite;
import com.bridge.renderHandler.sound.Sound;
import com.bridge.renderHandler.sprite.Coord;
import com.pac_man.Map.Maze;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Ghost.*;
import com.pac_man.characters.Ghost.BlinkyChaser;
import com.pac_man.characters.Ghost.ClydeChaser;
import com.pac_man.characters.Ghost.InkyChaser;
import com.pac_man.characters.Ghost.PinkyChaser;
import com.pac_man.characters.Pacman.Pacman;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GameInitializer {
    public void init() {
        URL pacmanImg = getClass().getResource("app/src/main/java/com/pac_man/Resources/PacMan/pr1.png");

        Path pacmanImgPath = null;
        try {
            pacmanImgPath = Paths.get(pacmanImg.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Sound pacmanSound = new Sound(null); // sounds aren't implemented

        Sprite pacManSprite = new Sprite(
                new Coord(0, 0),
                new Size(10.0, 10.0),
                pacmanImgPath
        );

        Pacman pacman = new Pacman(
                new Position(0, 0),
                pacManSprite,
                new KeyboardListener()
        );

        List<Ghost> ghosts = getGhosts(pacman);

        for (Ghost ghost : ghosts) {
            ghost.spawn();
        }

        Maze maze = new Maze();
    }


    private List<Ghost> getGhosts(Pacman pacman) {

        URL blinkyImg = getClass().getResource("app/src/main/java/com/pac_man/Resources/Ghosts/Blinky/red1.png");
        URL clydeImg = getClass().getResource("app/src/main/java/com/pac_man/Resources/Ghosts/Clyde/yell1.png");
        URL inkyImg = getClass().getResource("app/src/main/java/com/pac_man/Resources/Ghosts/Inky/blue1.png");
        URL pinkyImg = getClass().getResource("app/src/main/java/com/pac_man/Resources/Ghosts/Pinky/pink1.png");


        Path blinkyImgPath = null;
        Path clydeImgPath = null;
        Path inkyImgPath = null;
        Path pinkyImgPath = null;

        try {
            blinkyImgPath = Paths.get(blinkyImg.toURI());
            clydeImgPath = Paths.get(clydeImg.toURI());
            inkyImgPath = Paths.get(inkyImg.toURI());
            pinkyImgPath = Paths.get(pinkyImg.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Sprite blinkySprite = new Sprite(
                new Coord(0, 0),
                new Size(10.0, 10.0),
                blinkyImgPath
        );

        Sprite clydeSprite = new Sprite(
                new Coord(0, 0),
                new Size(10.0, 10.0),
                clydeImgPath
        );

        Sprite inkySprite = new Sprite(
                new Coord(0, 0),
                new Size(10.0, 10.0),
                inkyImgPath
        );

        Sprite pinkySprite = new Sprite(
                new Coord(0, 0),
                new Size(10.0, 10.0),
                pinkyImgPath
        );



        Maze maze = new Maze();

        Ghost blinky = new Ghost(
                new Position(0, 0),
                blinkySprite,
                pacman,
                new BlinkyChaser()
        );

        Ghost clyde = new Ghost(
                new Position(0, 0),
                clydeSprite,
                pacman,
                new ClydeChaser()
        );

        Ghost inky = new Ghost(
                new Position(0, 0),
                inkySprite,
                pacman,
                new InkyChaser()
        );

        Ghost pinky = new Ghost(
                new Position(0, 0),
                pinkySprite,
                pacman,
                new PinkyChaser()
        );

        List<Ghost> ghosts = new ArrayList<>();
        ghosts.add(blinky);
        ghosts.add(clyde);
        ghosts.add(inky);
        ghosts.add(pinky);

        return ghosts;
    }
}
