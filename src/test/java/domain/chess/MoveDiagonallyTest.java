package domain.chess;

import domain.chess.board.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MoveDiagonallyTest {

    @Test
    void checkDirection_참() {
        Location source = new Location("c1");
        Location target = new Location("g5");
        boolean result = false;

        if (source.getFileName() < target.getFileName() && source.getRankNumber() < target.getRankNumber()) {
            result = true;
        } else if (source.getFileName() > target.getFileName() && source.getRankNumber() > target.getRankNumber()) {
            result = true;
        } else if (source.getFileName() < target.getFileName() && source.getRankNumber() > target.getRankNumber()) {
            result = true;
        } else if (source.getFileName() > target.getFileName() && source.getRankNumber() < target.getRankNumber()) {
            result = true;
        }
        Assertions.assertTrue(result);
    }

    @Test
    void checkDirection_거짓() {
        Location source = new Location("g3");
        Location target = new Location("g5");
        boolean result = false;

        if (source.getFileName() < target.getFileName() && source.getRankNumber() < target.getRankNumber()) {
            result = true;
        } else if (source.getFileName() > target.getFileName() && source.getRankNumber() > target.getRankNumber()) {
            result = true;
        } else if (source.getFileName() < target.getFileName() && source.getRankNumber() > target.getRankNumber()) {
            result = true;
        } else if (source.getFileName() > target.getFileName() && source.getRankNumber() < target.getRankNumber()) {
            result = true;
        }
        Assertions.assertFalse(result);
    }
}
