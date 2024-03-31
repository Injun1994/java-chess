package domain.chess.piece;

import domain.chess.board.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class KingTest {

    @Test
    void isMoveable_참() {
        boolean result = false;
        Location source = new Location("b4");
        Location target = new Location("c3");

        for (int file = 0; file < King.COORDINATES_X.size(); file++) {
            if (target.getFileName() - source.getFileName() == King.COORDINATES_X.get(file)
                    && target.getRankNumber() - source.getRankNumber() == King.COORDINATES_Y.get(file)) {
                result = true;
            }
        }
        Assertions.assertTrue(result);
    }

    @Test
    void isMoveable_거짓() {
        boolean result = false;
        Location source = new Location("b4");
        Location target = new Location("d3");

        for (int file = 0; file < King.COORDINATES_X.size(); file++) {
            if (target.getFileName() - source.getFileName() == King.COORDINATES_X.get(file)
                    && target.getRankNumber() - source.getRankNumber() == King.COORDINATES_Y.get(file)) {
                result = true;
            }
        }
        Assertions.assertFalse(result);
    }
}
