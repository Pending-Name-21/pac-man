package com.pac_man.characters.Map;

public class Maze {
    private IBlock[][] maze;
    public Maze(IBlock[][] maze)
    {
        this.maze = maze;
    }
    
    public void populate()
    {}
    public IBlock[][] getBlocks()
    {
        return maze;
    }
}
