package domain.chess.piece;

import domain.chess.board.Checkerboard;
import domain.chess.board.Location;
import domain.chess.piece.attribute.Symbol;
import domain.chess.piece.attribute.Team;

import java.util.List;
import java.util.Map;

public class King implements Piece {

    public static final String BLACK_DEFAULT_LOCATION = "e8";
    public static final String WHITE_DEFAULT_LOCATION = "e1";
    public static final List<Integer> COORDINATES_X = List.of(0, 0, -1, 1, -1, 1, -1, 1);
    public static final List<Integer> COORDINATES_Y = List.of(1, -1, 0, 0, 1, 1, -1, -1);

    public static void setDefaultPosition(Location location, Map<Location, Character> positions) {
        if (location.getLocation().equals(BLACK_DEFAULT_LOCATION)) {
            positions.put(location, Symbol.KING.getName(Team.BLACK));
        } else if (location.getLocation().equals(WHITE_DEFAULT_LOCATION)) {
            positions.put(location, Symbol.KING.getName(Team.WHITE));
        }
    }

    @Override
    public boolean isMoveable(Location source, Location target) {
        for (int file = 0; file < COORDINATES_X.size(); file++) {
            if (target.getFileName() - source.getFileName() == COORDINATES_X.get(file)
                    && target.getRankNumber() - source.getRankNumber() == COORDINATES_Y.get(file)) {
                Checkerboard.isCheckable(source, target);
                return true;
            }
        }
        return false;
    }
}
