package domain.chess.piece;

import domain.chess.MoveDiagonally;
import domain.chess.MoveHorizontalOrVertical;
import domain.chess.board.Checkerboard;
import domain.chess.board.Location;
import domain.chess.piece.attribute.Symbol;
import domain.chess.piece.attribute.Team;

import java.util.Map;

public class Queen implements Piece {

    public static final String BLACK_DEFAULT_LOCATION = "d8";
    public static final String WHITE_DEFAULT_LOCATION = "d1";

    public static void setDefaultPosition(Location location, Map<Location, Character> positions) {
        if (location.getLocation().equals(BLACK_DEFAULT_LOCATION)) {
            positions.put(location, Symbol.QUEEN.getName(Team.BLACK));
        } else if (location.getLocation().equals(WHITE_DEFAULT_LOCATION)) {
            positions.put(location, Symbol.QUEEN.getName(Team.WHITE));
        }
    }

    @Override
    public boolean isMoveable(Location source, Location target) {
        MoveDiagonally moveDiagonally = new MoveDiagonally();
        MoveHorizontalOrVertical moveHorizontalOrVertical = new MoveHorizontalOrVertical();
        if (moveDiagonally.checkDirection(source, target) || moveHorizontalOrVertical.checkWayToGo(source, target)) {
            Checkerboard.isCheckable(source, target);
            return true;
        }
        return false;
    }
}
