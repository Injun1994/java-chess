package domain.chess.piece;

import domain.chess.board.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RookTest {

    @Test
    void isMoveable_참() {
        Location source = new Location("c1");
        Location target = new Location("c8");
        boolean result = false;
        if (source.getFileName() == target.getFileName() || source.getRankNumber() == target.getRankNumber()) {
            result = true;
        }
        Assertions.assertTrue(result);
    }

    @Test
    void isMoveable_거짓() {
        Location source = new Location("c1");
        Location target = new Location("b2");
        boolean result = false;
        if (source.getFileName() == target.getFileName() || source.getRankNumber() == target.getRankNumber()) {
            result = true;
        }
        Assertions.assertFalse(result);
    }
}
