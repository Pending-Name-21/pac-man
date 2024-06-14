package com.pac_man.Map;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.bridge.renderHandler.Coord;
import com.bridge.renderHandler.Size;
import com.bridge.renderHandler.sprite.Sprite;

public class Maze {
    private static final int NUM_ROWS = 21;
    private static final int NUM_COLS = 19;
    
    private IBlock[][] maze;

    public Maze() {
        this.maze = new IBlock[NUM_ROWS][NUM_COLS];
    }

    public IBlock[][] getBlocks() {
        return maze;
    }

    public void populateFromFile(String filePath) {

    }

}
