package com.pac_man.characters.Map;

public class TestingBlock implements IBlock{
    private boolean canEnter;

    public TestingBlock(boolean canEnter) {
        this.canEnter = canEnter;
    }

    @Override
    public boolean canEnter() {
        return canEnter;
    }
    
}
