package domain.chess.piece;

import domain.chess.board.Checkerboard;
import domain.chess.board.Location;
import domain.chess.piece.attribute.Symbol;
import domain.chess.piece.attribute.Team;

import java.util.Map;

public class King {

    public static final String BLACK_DEFAULT_LOCATION = "e8";
    public static final String WHITE_DEFAULT_LOCATION = "e1";

    public static void setDefaultPosition(Location location, Map<Location, Character> positions) {
        if (location.getLocation().equals(BLACK_DEFAULT_LOCATION)) {
            positions.put(location, Symbol.KING.getName(Team.BLACK));
        } else if (location.getLocation().equals(WHITE_DEFAULT_LOCATION)) {
            positions.put(location, Symbol.KING.getName(Team.WHITE));
        }
    }

    public boolean isMoveable(Location source, Location target) {
        int[][] coordinates = {{0, 1}, {0, -1}, {-1, 0}, {1, 0},
                                {-1, 1}, {1, 1}, {-1, -1}, {1, -1}};

        for (int file = 0; file < coordinates.length; file++) {
            if (target.getFileName() - source.getFileName() == coordinates[file][0]
                    && target.getRankNumber() - source.getRankNumber() == coordinates[file][1]) {
                Checkerboard.isCheckable(source, target);
                return true;
            }
        }
        return false;
    }
}
