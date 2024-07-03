package com.pac_man.characters.Ghost;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.bridge.core.exceptions.renderHandlerExceptions.NonExistentFilePathException;
import com.bridge.renderHandler.builders.SpriteBuilder;
import com.pac_man.Map.Maze;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Geometry.Tuple;
import com.pac_man.characters.Pacman.Pacman;
import com.pac_man.characters.Utils.Utils;

public class GhostGenerator {

    private SpriteBuilder spriteBuilder;
    private List<Tuple<Ghost, Position>> ghostPositions = new ArrayList<>();
    private int ghostCounter = 0;
    private final int MAX_GHOST = 4;
    private Pacman pacman;
    private String projectPath = Paths.get("").toAbsolutePath().toString();

    public GhostGenerator(SpriteBuilder spriteBuilder, Pacman pacman) {
        this.spriteBuilder = spriteBuilder;
        this.pacman = pacman;

    }
    public void populate(Maze maze)
    {
        List<Position> emptyPositions = Utils.getEmptyPositions(maze);
        for (int i = 0; i < MAX_GHOST && !emptyPositions.isEmpty(); i++){
            Position pos = emptyPositions.remove(new Random().nextInt(emptyPositions.size()));
            IChase nextChaser = getNextChaser();
            Ghost ghost = createGhosts(pos, i, nextChaser);
            ghostPositions.add(new Tuple<>(ghost, pos));
        }
    }

    public Ghost spawnGhost(Position position, IChase chase)
    {
        return new Ghost(position, chase);
    }

    private IChase getNextChaser()
    {
        switch (ghostCounter % 4) {
            case 0:
                return new BlinkyChaser();
            case 1:
                return new PinkyChaser();
            case 2:
                return new InkyChaser();
            case 3:
                return new ClydeChaser();            
            default:
                return new ClydeChaser();
        }
    }

    public List<Tuple<Ghost, Position>> getGhostsPositions()
    {
        return ghostPositions;
    }

    public Ghost createGhosts (Position pos, int val, IChase chase) {
        spriteBuilder.buildCoord(pos.getX(), pos.getY());
        spriteBuilder.buildSize(10, 10);

        switch (val) {
            case 0:
                try {
                    spriteBuilder.buildPath(projectPath + "/src/main/java/com/pac_man/Resources/Ghosts/Blinky/red1.png");
                } catch (NonExistentFilePathException e) {
                    throw new RuntimeException(e);
                }
            case 1:
                try {
                    spriteBuilder.buildPath(projectPath + "/src/main/java/com/pac_man/Resources/Ghosts/Pinky/pink1.png");
                } catch (NonExistentFilePathException e) {
                    throw new RuntimeException(e);
                }
            case 2:
                try {
                    spriteBuilder.buildPath(projectPath + "/src/main/java/com/pac_man/Resources/Ghosts/Inky/blue1.png");
                } catch (NonExistentFilePathException e) {
                    throw new RuntimeException(e);
                }
            case 3:
                try {
                    spriteBuilder.buildPath(projectPath + "/src/main/java/com/pac_man/Resources/Ghosts/Clyde/yell1.png");
                } catch (NonExistentFilePathException e) {
                    throw new RuntimeException(e);
                }
        }

        return new Ghost(pos, spriteBuilder.assemble(), pacman, chase);

    }
}
