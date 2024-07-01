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
import com.bridge.initializerhandler.GameInitializer;
import com.bridge.gamesettings.AGameSettings;
import com.bridge.processinputhandler.ProcessInputPublisher;
import com.bridge.initializerhandler.IIinitializerSubscriber;
import com.bridge.processinputhandler.EventType;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class PacManGameInitializer {
    public void init() {
        Maze maze = new Maze();
        maze.populateFromFile("app/src/main/java/com/pac_man/Resources/MazeElement/Map.txt");

        Sound pacmanSound = new Sound(null); // sounds aren't implemented

        Sprite pacManSprite = new Sprite(
                new Coord(0, 0),
                new Size(10.0, 10.0),
                Path.of("app/src/main/java/com/pac_man/Resources/PacMan/pr1.png")
        );

        Pacman pacman = new Pacman(
                new Position(0, 0),
                pacManSprite,
                new KeyboardListener()
        );

        pacman.spawn();

        List<Ghost> ghosts = getGhosts(pacman);
        for (Ghost ghost : ghosts) {
            ghost.spawn();
        }


        

    }


    private List<Ghost> getGhosts(Pacman pacman) {

        Sprite blinkySprite = new Sprite(
                new Coord(0, 0),
                new Size(10.0, 10.0),
                Path.of("app/src/main/java/com/pac_man/Resources/Ghosts/Blinky/red1.png")

        );

        Sprite clydeSprite = new Sprite(
                new Coord(0, 0),
                new Size(10.0, 10.0),
                Path.of("app/src/main/java/com/pac_man/Resources/Ghosts/Clyde/yell1.png")
        );

        Sprite inkySprite = new Sprite(
                new Coord(0, 0),
                new Size(10.0, 10.0),
                Path.of("app/src/main/java/com/pac_man/Resources/Ghosts/Inky/blue1.png")
        );

        Sprite pinkySprite = new Sprite(
                new Coord(0, 0),
                new Size(10.0, 10.0),
                Path.of("app/src/main/java/com/pac_man/Resources/Ghosts/Pinky/pink1.png")
        );

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
