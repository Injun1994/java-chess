package domain.chess;

import domain.chess.board.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MoveHorizontalOrVerticalTest {

    @Test
    void checkWayToGo() {
        Location source = new Location("c1");
        Location target = new Location("h1");
        boolean result;

        if (source.getFileName() == target.getFileName()) {
            if (Math.abs(target.getRankNumber() - source.getRankNumber()) > 1) {
                result = true;
            } else {
                result = false;
            }
        } else {
            if (Math.abs(target.getFileName() - source.getFileName()) > 1) {
                result = true;
            } else {
                result = false;
            }
        }
        Assertions.assertTrue(result);
    }
}
