package domain.chess;

import domain.chess.board.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;


class MoveDiagonallyTest {

    @Test
    void checkDirection() {
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
}
