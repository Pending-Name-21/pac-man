package com.pac_man.Map;

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
