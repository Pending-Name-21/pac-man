package com.pac_man.Map;


import com.bridge.renderHandler.sprite.Sprite;
import com.pac_man.Collisions.Body;

public class SpawnBlock implements IBlock {
    private Sprite sprite;

    public SpawnBlock(Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public boolean canEnter() {
        return true; 
    }

    public void exit(Body body) {
    }

    public Sprite getSprite() {
        return sprite;
    }
}
