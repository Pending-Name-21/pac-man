package com.pac_man.Map;
import com.bridge.renderHandler.sprite.Sprite;
import com.pac_man.Collisions.Body;


public class WallBlock implements IBlock {

    private Sprite sprite;

    public WallBlock (Sprite sprite)
    {
        this.sprite = sprite;
    }

    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public boolean canEnter() {
        return false; 
    }

    @Override
    public void exit(Body body) {
        sprite.setHidden(true);
    }


}