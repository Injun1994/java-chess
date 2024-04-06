package domain.chess.piece;

import domain.chess.board.Location;

public interface Piece {

    boolean isMoveable(Location source, Location target);
}
