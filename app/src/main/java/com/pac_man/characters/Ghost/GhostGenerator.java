package com.pac_man.characters.Ghost;

import java.util.ArrayList;
import java.util.List;

import com.pac_man.characters.Map.Maze;
import com.pac_man.characters.Tools.Position;
import com.pac_man.characters.Tools.Utils;

public class GhostGenerator {

    private List<Ghost> ghosts = new ArrayList<>();
    private int ghostCounter = 0;

    public void populate(Maze maze)
    {
        List<Position> emptyPositions = Utils.getEmptyPositions(maze);
        if (emptyPositions.size() > 0) {
            for (Position pos : emptyPositions) {
                IChase nextChaser = getNextChaser();
                ghostCounter++;
                ghosts.add(spawnGhost(pos, nextChaser));
            }
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
}
