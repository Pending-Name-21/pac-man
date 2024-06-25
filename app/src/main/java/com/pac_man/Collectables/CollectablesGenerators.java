package com.pac_man.Collectables;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.pac_man.Map.Maze;
import com.pac_man.characters.Geometry.Position;
import com.pac_man.characters.Geometry.Tuple;
import com.pac_man.characters.Utils.Utils;

public class CollectablesGenerators  {
    
    private List<Tuple<Sphere, Position>> spherePositions = new ArrayList<>();
    private List<Tuple<PowerSphere, Position>> powerSpherePositions = new ArrayList<>();
    private final int MAX_SPHERES = 240;
    private final int MAX_POWER_SHPERES = 4;

    public void populate(Maze maze)
    {
        List<Position> emptyPositions = Utils.getEmptyPositions(maze);
        for (int i = 0; i < MAX_SPHERES  && !emptyPositions.isEmpty(); i++){
            Position pos = emptyPositions.remove(new Random().nextInt(emptyPositions.size()));
            Sphere sphere = generateShpere(pos);
            spherePositions.add(new Tuple<>(sphere, pos));
        }

        for (int i = 0; i < MAX_POWER_SHPERES && !emptyPositions.isEmpty(); i++){
            Position pos = emptyPositions.remove(new Random().nextInt(emptyPositions.size()));
            PowerSphere sphere = generatePowerShpere(pos);
            powerSpherePositions.add(new Tuple<>(sphere, pos));
        }
    }

    public List<Tuple<Sphere, Position>> getSphereList() {
        return spherePositions;
    }

    public List<Tuple<PowerSphere, Position>> getPowerSphereList() {
        return powerSpherePositions;
    }

    public Sphere generateShpere (Position position) {
        return new Sphere(null, position);
    }

    public PowerSphere generatePowerShpere (Position position) {
        return new PowerSphere(null, position);
    }
}
