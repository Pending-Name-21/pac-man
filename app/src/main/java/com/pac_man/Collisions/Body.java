package com.pac_man.Collisions;


public class Body {
    
    private String identifier;
    private ICollisionSubscriber element;

    public Body(String identifier, ICollisionSubscriber element) {
        this.identifier = identifier;
        this.element = element;
    }

    public String getIdentifier() {
        return identifier;
    }

    public ICollisionSubscriber getElement() {
        return element;
    }
}