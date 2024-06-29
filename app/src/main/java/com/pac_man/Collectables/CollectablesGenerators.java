package com.pac_man.Collectables;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.bridge.renderHandler.sprite.Size;
import com.bridge.renderHandler.sprite.Coord;
import com.bridge.renderHandler.sprite.Sprite;
import com.pac_man.Map.Maze;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Geometry.Tuple;
import com.pac_man.characters.Utils.Utils;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CollectablesGenerators  {
    
    private List<Tuple<Sphere, Position>> spherePositions;
    private List<Tuple<PowerSphere, Position>> powerSpherePositions;
    private final int MAX_SPHERES = 240;
    private final int MAX_POWER_SPHERES = 4; 
    private final Size SPHERE_SIZE;
    private final Path SPHERE_PATH; 
    private final Size POWER_SPHERE_SIZE;
    private final Path POWER_SPHERE_PATH;

    public CollectablesGenerators() {
        spherePositions = new ArrayList<>();
        powerSpherePositions = new ArrayList<>();
        SPHERE_SIZE = new Size(100, 100);
        SPHERE_PATH = Paths.get("app", "src", "main", "java", "com", "pac_man", "Resources", "MazeElement", "smallDot.png");
        POWER_SPHERE_SIZE = new Size(200, 200);
        POWER_SPHERE_PATH = Paths.get("app", "src", "main", "java", "com", "pac_man", "Resources", "MazeElement", "whiteDot.png");
    }

    public void populate(Maze maze)
    {
        List<Position> emptyPositions = Utils.getEmptyPositions(maze);
        for (int i = 0; i < MAX_SPHERES  && !emptyPositions.isEmpty(); i++){
            Position pos = emptyPositions.remove(new Random().nextInt(emptyPositions.size()));
            Sphere sphere = generateSphere(pos);
            spherePositions.add(new Tuple<>(sphere, pos));
        }

        for (int i = 0; i < MAX_POWER_SPHERES && !emptyPositions.isEmpty(); i++){
            Position pos = emptyPositions.remove(new Random().nextInt(emptyPositions.size()));
            PowerSphere sphere = generatePowerSphere(pos);
            powerSpherePositions.add(new Tuple<>(sphere, pos));
        }
    }

    public List<Tuple<Sphere, Position>> getSphereList() {
        return spherePositions;
    }

    public List<Tuple<PowerSphere, Position>> getPowerSphereList() {
        return powerSpherePositions;
    }

    private Sphere generateSphere (Position position) {
        Coord coords = new Coord(position.getX(), position.getY());
        Sprite sprite = new Sprite(coords, SPHERE_SIZE, SPHERE_PATH);
        return new Sphere(sprite, position);
    }

    private PowerSphere generatePowerSphere (Position position) {
        Coord coords = new Coord(position.getX(), position.getY());
        Sprite sprite = new Sprite(coords, POWER_SPHERE_SIZE, POWER_SPHERE_PATH);
        return new PowerSphere(sprite, position);
    }
}
