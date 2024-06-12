package com.pac_man.characters;

import com.pac_man.characters.Pacman.Block;
import com.pac_man.characters.Tools.Position;

public abstract class ACharacter {
    private Position spawnPosition;
    private Position position;
    private Block current;

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

    public Block getCurrent() {
        return this.current;
    }

    public void setCurrent(Block current) {
        this.current = current;
    }
}
