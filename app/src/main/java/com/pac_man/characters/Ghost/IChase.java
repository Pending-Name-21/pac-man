package com.pac_man.characters.Ghost;

import com.pac_man.characters.Geometry.Direction;
import com.pac_man.characters.Geometry.Position;

public interface IChase {
    Position chase(Position targetPosition, Direction targetDirection, Position chaserPosition);
}
