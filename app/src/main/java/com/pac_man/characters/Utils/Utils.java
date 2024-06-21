package com.pac_man.characters.Utils;

import java.util.ArrayList;
import java.util.List;

import com.pac_man.Map.IBlock;
import com.pac_man.Map.Maze;
import com.pac_man.characters.Geometry.Position;

public class Utils {
        public static List<Position> getEmptyPositions(Maze maze) {
        List<Position> emptyPositions = new ArrayList<>();
        IBlock[][] mazeBlocks = maze.getBlocks();

        for (int i = 0; i < mazeBlocks.length; i++) {
            for (int j = 0; j < mazeBlocks[i].length; j++) {
                if (mazeBlocks[i][j].canEnter()) {
                    emptyPositions.add(new Position(i, j));
                }
            }
        }
        return emptyPositions;
    }
}
