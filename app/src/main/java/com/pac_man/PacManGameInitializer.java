package com.pac_man;

import com.bridge.Game;
import com.bridge.core.exceptions.renderHandlerExceptions.NonExistentFilePathException;
import com.bridge.initializerhandler.IIinitializerSubscriber;
import com.bridge.processinputhandler.KeyboardEventManager;
import com.bridge.renderHandler.builders.SpriteBuilder;
import com.bridge.renderHandler.repository.SpriteRepository;
import com.bridge.renderHandler.sound.Sound;
import com.bridge.updatehandler.UpdatePublisher;
import com.pac_man.Map.Maze;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Ghost.*;
import com.pac_man.characters.Pacman.Pacman;

import java.nio.file.Paths;

public class PacManGameInitializer implements IIinitializerSubscriber {
    private Pacman pacman;
    private String projectPath = Paths.get("").toAbsolutePath().toString();
    private Game game;

    public PacManGameInitializer(Game game) {
        this.game = game;
    }

    public void init() {

        game.getKeyboardEventManager().subscribe(pacman);
        Maze maze = new Maze();

        //String aux= projectPath + "app/src/main/resources/MazeElement/Map.txt";
        String aux = projectPath + "MazeElement/Map.txt";
        maze.populateFromFile(aux);


        //Sound pacmanSound = new Sound(""); // sounds aren't implemented

        SpriteBuilder pacManSprite = new SpriteBuilder(game.getSpriteIRepository());
        pacManSprite.buildCoord(0, 0);
        pacManSprite.buildSize(10, 10);
        try {
            pacManSprite.buildPath("PacMan/pr1.png");
            //pacManSprite.buildPath(projectPath + "app/src/main/resources/PacMan/pr1.png");
        } catch (NonExistentFilePathException e) {
            throw new RuntimeException(e);
        }

        this.pacman = new Pacman(
                new Position(0, 0),
                pacManSprite.assemble()
        );

        game.getUpdatePublisher().subscribe(pacman);

        SpriteBuilder ghostBuilder = setGhostsSprites();
        GhostGenerator generator = new GhostGenerator(ghostBuilder, pacman);
        generator.populate(maze);


    }


    public Pacman getPacman() {
        return this.pacman;
    }

    private SpriteBuilder setGhostsSprites() {
        SpriteBuilder ghostSpriteBuilder = new SpriteBuilder(game.getSpriteIRepository());
        ghostSpriteBuilder.buildCoord(0, 0);
        try {
            ghostSpriteBuilder.buildPath("Ghosts/Blinky/red1.png");
            //ghostSpriteBuilder.buildPath(projectPath + "app/src/main/resources/Ghosts/Blinky/red1.png");
        } catch (NonExistentFilePathException e) {
            throw new RuntimeException(e);
        }
        ghostSpriteBuilder.buildSize(10.0, 10.0);
        ghostSpriteBuilder.assemble();

        ghostSpriteBuilder.buildCoord(0, 0);
        try {
            ghostSpriteBuilder.buildPath("Ghosts/Clyde/yell1.png");
            //ghostSpriteBuilder.buildPath(projectPath + "app/src/main/resources/Ghosts/Clyde/yell1.png");
        } catch (NonExistentFilePathException e) {
            throw new RuntimeException(e);
        }
        ghostSpriteBuilder.buildSize(10.0, 10.0);
        ghostSpriteBuilder.assemble();

        ghostSpriteBuilder.buildCoord(0, 0);
        try {
            ghostSpriteBuilder.buildPath("Ghosts/Inky/blue1.png");
            //ghostSpriteBuilder.buildPath(projectPath + "app/src/main/resources/Ghosts/Inky/blue1.png");
        } catch (NonExistentFilePathException e) {
            throw new RuntimeException(e);
        }
        ghostSpriteBuilder.buildSize(10.0, 10.0);
        ghostSpriteBuilder.assemble();

        ghostSpriteBuilder.buildCoord(0, 0);
        try {
            ghostSpriteBuilder.buildPath("Ghosts/Pinky/pink1.png");
            //ghostSpriteBuilder.buildPath(projectPath + "app/src/main/resources/Ghosts/Pinky/pink1.png");
        } catch (NonExistentFilePathException e) {
            throw new RuntimeException(e);
        }
        ghostSpriteBuilder.buildSize(10.0, 10.0);
        ghostSpriteBuilder.assemble();

        return ghostSpriteBuilder;
    }
}
