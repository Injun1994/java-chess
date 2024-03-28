package domain.chess.piece;

import domain.chess.board.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class KingTest {

    @Test
    void isMoveable() {
        boolean result = false;
        Location source = new Location("b4");
        Location target = new Location("c3");
        int[][] coordinates = {{0, 1}, {0, -1}, {-1, 0}, {1, 0},
                {-1, 1}, {1, 1}, {-1, -1}, {1, -1}};

        for (int file = 0; file < coordinates.length; file++) {
            if (target.getFileName() - source.getFileName() == coordinates[file][0]
                    && target.getRankNumber() - source.getRankNumber() == coordinates[file][1]) {
                result = true;
            }
        }
        Assertions.assertTrue(result);
    }
}
