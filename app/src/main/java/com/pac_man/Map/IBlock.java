package com.pac_man.Map;

import com.pac_man.Collisions.Body;

public interface IBlock {
    boolean canEnter();
    public void exit(Body body);
}