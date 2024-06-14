package com.pac_man.characters.Ghost;

import com.pac_man.characters.Tools.Direction;
import com.pac_man.characters.Tools.Position;

public interface IChase {
    Position chase(Position targetPosition, Direction targetDirection, Position chaserPosition);
}
