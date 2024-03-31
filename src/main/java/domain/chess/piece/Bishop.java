package domain.chess.piece;

import domain.chess.Move;
import domain.chess.MoveDiagonally;
import domain.chess.board.Checkerboard;
import domain.chess.board.Location;
import domain.chess.piece.attribute.Symbol;
import domain.chess.piece.attribute.Team;

import java.util.Map;

public class Bishop implements Piece {

    public static final String BLACK_DEFAULT_LOCATION_ONE = "c8";
    public static final String BLACK_DEFAULT_LOCATION_TWO = "f8";
    public static final String WHITE_DEFAULT_LOCATION_ONE = "c1";
    public static final String WHITE_DEFAULT_LOCATION_TWO = "f1";

    public static void setDefaultPosition(Location location, Map<Location, Character> positions) {
        if (location.getLocation().equals(BLACK_DEFAULT_LOCATION_ONE) || location.getLocation().equals(BLACK_DEFAULT_LOCATION_TWO)) {
            positions.put(location, Symbol.BISHOP.getName(Team.BLACK));
        } else if (location.getLocation().equals(WHITE_DEFAULT_LOCATION_ONE) || location.getLocation().equals(WHITE_DEFAULT_LOCATION_TWO)) {
            positions.put(location, Symbol.BISHOP.getName(Team.WHITE));
        }
    }

    @Override
    public boolean isMoveable(Location source, Location target) {
        if (Move.isDiagonal(source, target)) {
            return isNoPieceOnTheWay(source, target);
        }
        return false;
    }

    public boolean isNoPieceOnTheWay(Location source, Location target) {
        if (new MoveDiagonally().checkDirection(source, target)) {
            Checkerboard.isCheckable(source, target);
            return true;
        }
        return false;
    }
}
