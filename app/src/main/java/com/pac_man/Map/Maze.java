package com.pac_man.Map;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.bridge.renderHandler.sprite.Coord;
import com.bridge.renderHandler.sprite.Size;
import com.bridge.renderHandler.sprite.Sprite;

public class Maze {
    private static final int NUM_ROWS = 21;
    private static final int NUM_COLS = 19;
    private String projectPath = Paths.get("").toAbsolutePath().toString();
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

    public void populateFromFile(String resourcePath) {
        try (InputStream inputStream = getClass().getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("File not found: " + resourcePath);
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                List<String> lines = reader.lines().collect(Collectors.toList());
                for (int i = 0; i < NUM_ROWS; i++) {
                    String line = lines.get(i);
                    for (int j = 0; j < NUM_COLS; j++) {
                        char blockType = line.charAt(j);
                        maze[i][j] = createBlock(blockType, i, j);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private IBlock createBlock(char blockType, int x, int y) {
        switch (blockType) {
            case 'S':
                return new StepBlock(new Sprite(new Coord(x, y), 0, new Size(1, 1), Paths.get(projectPath + "/src/main/Resources/general/StepBlock.png")));
            case 'W':
                return new WallBlock(new Sprite(new Coord(x, y), 0, new Size(1, 1), Paths.get(projectPath + "/src/main/Resources/general/wall.png")));
            case 'P':
                return new SpawnBlock(new Sprite(new Coord(x, y), 0, new Size(1, 1), Paths.get("")));
            default:
                throw new IllegalArgumentException("Unknown block type: " + blockType);
        }
    }

}
