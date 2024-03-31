package domain.chess.piece;

import domain.chess.MoveHorizontalOrVertical;
import domain.chess.board.Checkerboard;
import domain.chess.board.Location;
import domain.chess.piece.attribute.Symbol;
import domain.chess.piece.attribute.Team;

import java.util.Map;

public class Rook implements Piece {

    public static final String BLACK_DEFAULT_LOCATION_ONE = "a8";
    public static final String BLACK_DEFAULT_LOCATION_TWO = "h8";
    public static final String WHITE_DEFAULT_LOCATION_ONE = "a1";
    public static final String WHITE_DEFAULT_LOCATION_TWO = "h1";

    public static void setDefaultPosition(Location location, Map<Location, Character> positions) {
        if (location.getLocation().equals(BLACK_DEFAULT_LOCATION_ONE)) {
            positions.put(location, Symbol.ROOK.getName(Team.BLACK));
        } else if (location.getLocation().equals(BLACK_DEFAULT_LOCATION_TWO)) {
            positions.put(location, Symbol.ROOK.getName(Team.BLACK));
        } else if (location.getLocation().equals(WHITE_DEFAULT_LOCATION_ONE)) {
            positions.put(location, Symbol.ROOK.getName(Team.WHITE));
        } else if (location.getLocation().equals(WHITE_DEFAULT_LOCATION_TWO)) {
            positions.put(location, Symbol.ROOK.getName(Team.WHITE));
        }
    }

    @Override
    public boolean isMoveable(Location source, Location target) {
        if (new MoveHorizontalOrVertical().checkWayToGo(source, target)) {
            Checkerboard.isCheckable(source, target);
            return true;
        }
        return false;
    }
}
