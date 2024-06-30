package com.pac_man.Collisions;

import java.util.ArrayList;
import java.util.List;

public class CollisionHandler {
  final List<ICollisionSubscriber> subscribers;

  public CollisionHandler() {
      subscribers = new ArrayList<>();
  }

  public void addSubscriber(ICollisionSubscriber subscriber) {
      subscribers.add(subscriber);
  }

  public void handleCollision(String[] bodies, Nature nature) {
      for (ICollisionSubscriber subscriber : subscribers) {
          subscriber.handleCollision(bodies, nature);
      }
  }
}