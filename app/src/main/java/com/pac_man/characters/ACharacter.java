package com.pac_man.characters;

import com.pac_man.Map.IBlock;
import com.pac_man.characters.Geometry.Position;

public abstract class ACharacter {
    protected Position spawnPosition;
    private Position position;
    private IBlock current;

    public ACharacter(Position spawnPosition) {
        this.spawnPosition = spawnPosition;
        this.position = spawnPosition;
    }

    public void spawn() {
        this.position = this.spawnPosition;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public IBlock getCurrent() {
        return this.current;
    }

    public void setCurrent(IBlock current) {
        this.current = current;
    }
}
