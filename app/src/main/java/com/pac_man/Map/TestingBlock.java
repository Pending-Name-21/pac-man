package com.pac_man.Map;

import com.pac_man.Collisions.Body;

public class TestingBlock implements IBlock{
    private boolean canEnter;

    public TestingBlock(boolean canEnter) {
        this.canEnter = canEnter;
    }

    @Override
    public boolean canEnter() {
        return canEnter;
    }

    @Override
    public void exit(Body body){
        body.notify();
    }
    
}
