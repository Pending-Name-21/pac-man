package com.pac_man.Map;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.bridge.renderHandler.sprite.Coord;
import com.bridge.renderHandler.sprite.Size;
import com.bridge.renderHandler.sprite.Sprite;

public class Maze {
    private static final int NUM_ROWS = 21;
    private static final int NUM_COLS = 19;
    
    private IBlock[][] maze;

    public Maze() {
        this.maze = new IBlock[NUM_ROWS][NUM_COLS];
    }
    
    public Maze(IBlock[][] maze)
    {
        this.maze = maze;
    }

    public IBlock[][] getBlocks() {
        return maze;
    }

    public void populateFromFile(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (int i = 0; i < NUM_ROWS; i++) {
                String line = lines.get(i);
                for (int j = 0; j < NUM_COLS; j++) {
                    char blockType = line.charAt(j);
                    maze[i][j] = createBlock(blockType, i, j);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private IBlock createBlock(char blockType, int x, int y) {
        switch (blockType) {
            case 'S':
                return new StepBlock(new Sprite(new Coord(x, y), new Size(1, 1), Paths.get("app/src/main/Resources/general/StepBlock.png")));
            case 'W':
                return new WallBlock(new Sprite(new Coord(x, y), new Size(1, 1), Paths.get("app/src/main/Resources/general/wall.png")));
            case 'P':
                return new SpawnBlock(new Sprite(new Coord(x, y), new Size(1, 1), Paths.get("")));
            default:
                throw new IllegalArgumentException("Unknown block type: " + blockType);
        }
    }

}
