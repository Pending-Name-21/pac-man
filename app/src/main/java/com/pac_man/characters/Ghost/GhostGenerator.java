package com.pac_man.characters.Ghost;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.pac_man.Map.Maze;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Geometry.Tuple;
import com.pac_man.characters.Utils.Utils;

public class GhostGenerator {

    private List<Tuple<Ghost, Position>> ghostPositions = new ArrayList<>();
    private int ghostCounter = 0;
    private final int MAX_GHOST = 4;

    public void populate(Maze maze)
    {
        List<Position> emptyPositions = Utils.getEmptyPositions(maze);
        for (int i = 0; i < MAX_GHOST && !emptyPositions.isEmpty(); i++){
            Position pos = emptyPositions.remove(new Random().nextInt(emptyPositions.size()));
            IChase nextChaser = getNextChaser();
            Ghost ghost = spawnGhost(pos, nextChaser);
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
}
