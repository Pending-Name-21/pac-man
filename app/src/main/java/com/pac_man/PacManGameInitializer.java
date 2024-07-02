package com.pac_man;

import com.bridge.core.exceptions.renderHandlerExceptions.NonExistentFilePathException;
import com.bridge.initializerhandler.IIinitializerSubscriber;
import com.bridge.processinputhandler.KeyboardEventManager;
import com.bridge.renderHandler.builders.SpriteBuilder;
import com.bridge.renderHandler.repository.SpriteRepository;
import com.bridge.renderHandler.sound.Sound;
import com.bridge.renderHandler.sprite.Coord;
import com.bridge.renderHandler.sprite.Size;
import com.bridge.renderHandler.sprite.Sprite;
import com.bridge.updatehandler.UpdatePublisher;
import com.pac_man.Map.Maze;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Ghost.*;
import com.pac_man.characters.Ghost.BlinkyChaser;
import com.pac_man.characters.Ghost.ClydeChaser;
import com.pac_man.characters.Ghost.InkyChaser;
import com.pac_man.characters.Ghost.PinkyChaser;
import com.pac_man.characters.Pacman.Pacman;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class PacManGameInitializer implements IIinitializerSubscriber {
    private Pacman pacman;
    private KeyboardEventManager keyboardEventManager;
    private UpdatePublisher updatePublisher;

    public void init() {

        SpriteRepository spriteRepository = new SpriteRepository();
        Maze maze = new Maze();
        maze.populateFromFile("app/src/main/java/com/pac_man/Resources/MazeElement/Map.txt");

        Sound pacmanSound = new Sound(null); // sounds aren't implemented

        SpriteBuilder pacManSprite = new SpriteBuilder(spriteRepository);
        pacManSprite.buildCoord(0,0);
        pacManSprite.buildSize(10,10);
        try {
            pacManSprite.buildPath("app/src/main/java/com/pac_man/Resources/PacMan/pr1.png");
        } catch (NonExistentFilePathException e) {
            throw new RuntimeException(e);
        }

        this.pacman = new Pacman(
                new Position(0, 0),
                pacManSprite.assemble()
        );

        this.updatePublisher = new UpdatePublisher();
        updatePublisher.subscribe(this.pacman);

        this.keyboardEventManager = new KeyboardEventManager();
        keyboardEventManager.subscribe(this.pacman);


        SpriteBuilder ghostSpriteBuilder = new SpriteBuilder(spriteRepository);
        ghostSpriteBuilder.buildCoord(0,0);
        try {
            ghostSpriteBuilder.buildPath("app/src/main/java/com/pac_man/Resources/Ghosts/Blinky/red1.png");
        } catch (NonExistentFilePathException e) {
            throw new RuntimeException(e);
        }
        ghostSpriteBuilder.buildSize(10.0,10.0);
        ghostSpriteBuilder.assemble();

        //GhostGenerator generator = new GhostGenerator();
        //generator.


    }


    public Pacman getPacman() {
        return this.pacman;
    }

    public KeyboardEventManager getKeyboardEventManager() {
        return this.keyboardEventManager;
    }

    public UpdatePublisher getUpdatePublisher (){
        return this.updatePublisher;
    }
}
