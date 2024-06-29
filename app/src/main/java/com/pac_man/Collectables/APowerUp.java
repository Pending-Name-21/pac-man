package com.pac_man.Collectables;

import com.bridge.renderHandler.sprite.Sprite;
import com.pac_man.Collisions.ICollisionSubscriber;
import com.pac_man.Map.IBlock;

public abstract class APowerUp implements ICollisionSubscriber {
    protected Sprite sprite;
    protected IBlock block;
}
