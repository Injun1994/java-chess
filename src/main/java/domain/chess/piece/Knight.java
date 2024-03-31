package domain.chess.piece;

import domain.chess.board.Checkerboard;
import domain.chess.board.Location;
import domain.chess.piece.attribute.Symbol;
import domain.chess.piece.attribute.Team;

import java.util.Map;

public class Knight implements Piece {

    public static final String BLACK_DEFAULT_LOCATION_ONE = "b8";
    public static final String BLACK_DEFAULT_LOCATION_TWO = "g8";
    public static final String WHITE_DEFAULT_LOCATION_ONE = "b1";
    public static final String WHITE_DEFAULT_LOCATION_TWO = "g1";
    public static final int MAX_MOVEABLE_SPACES = 2;
    public static final int MIN_MOVEABLE_SPACES = 1;

    public static void setDefaultPosition(Location location, Map<Location, Character> positions) {
        if (location.getLocation().equals(BLACK_DEFAULT_LOCATION_ONE)) {
            positions.put(location, Symbol.KNIGHT.getName(Team.BLACK));
        } else if (location.getLocation().equals(BLACK_DEFAULT_LOCATION_TWO)) {
            positions.put(location, Symbol.KNIGHT.getName(Team.BLACK));
        } else if (location.getLocation().equals(WHITE_DEFAULT_LOCATION_ONE)) {
            positions.put(location, Symbol.KNIGHT.getName(Team.WHITE));
        } else if (location.getLocation().equals(WHITE_DEFAULT_LOCATION_TWO)) {
            positions.put(location, Symbol.KNIGHT.getName(Team.WHITE));
        }
    }

    @Override
    public boolean isMoveable(Location source, Location target) {
        boolean isMoveable = false;

        if (Math.abs(target.getFileName() - source.getFileName()) == MAX_MOVEABLE_SPACES && Math.abs(target.getRankNumber() - source.getRankNumber()) == MIN_MOVEABLE_SPACES) {
            isMoveable = true;
        } else if (Math.abs(target.getFileName() - source.getFileName()) == MIN_MOVEABLE_SPACES && Math.abs(target.getRankNumber() - source.getRankNumber()) == MAX_MOVEABLE_SPACES) {
            isMoveable = true;
        }
        if (isMoveable) {
            Checkerboard.isCheckable(source, target);
        }
        return isMoveable;
    }
}
