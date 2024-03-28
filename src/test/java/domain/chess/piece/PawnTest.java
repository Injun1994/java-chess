package domain.chess.piece;

import domain.chess.board.Checkerboard;
import domain.chess.board.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class PawnTest {

    @Test
    void isMoveable() {
        Location source = new Location("b2");
        Location target = new Location("b3");

        boolean isStartRank = false;
        boolean isAvailableInterval = false;

        if (source.getRankNumber() == Pawn.BLACK_DEFAULT_LOCATION_ALL_RANK || source.getRankNumber() == Pawn.WHITE_DEFAULT_LOCATION_ALL_RANK) {
            isStartRank = true;
        }
        if (target.getFileName() == source.getFileName() && Math.abs(target.getRankNumber() - source.getRankNumber()) == Pawn.MAX_MOVEABLE_SPACES) {
            isAvailableInterval = true;
        }
        Assertions.assertTrue(isStartRank);
        Assertions.assertTrue(isAvailableInterval);
    }

    @Test
    void isNoPieceOnTheWay() {
        boolean result = true;
        Map<Location, Character> positions = new HashMap<>();
        Location position = new Location("b6");
        positions.put(position, 'P');
        Location source = new Location("b7");
        Location target = new Location("b5");
        int minNumber = Math.min(source.getRankNumber(), target.getRankNumber());
        int maxNumber = Math.max(source.getRankNumber(), target.getRankNumber());

        for (Location p : positions.keySet()) {
            for (int rank = minNumber; rank <= maxNumber; rank++) {
                if (!position.getLocation().equals(source.getLocation()) && position.getRankNumber() == rank && position.getFileName() == source.getFileName()) {
                    if (positions.get(p) != Checkerboard.NONE) {
                        result = false;
                    }
                }
            }
        }
        Assertions.assertFalse(result);
    }
}
