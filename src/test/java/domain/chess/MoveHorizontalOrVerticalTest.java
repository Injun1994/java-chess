package domain.chess;

import domain.chess.board.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MoveHorizontalOrVerticalTest {

    @Test
    void checkWayToGo_참() {
        Location source = new Location("c1");
        Location target = new Location("h1");
        boolean result = false;

        if (source.getFileName() == target.getFileName()) {
            if (Math.abs(target.getRankNumber() - source.getRankNumber()) > 1) {
                result = true;
            } else {
                result = false;
            }
        } else if (source.getRankNumber() == target.getRankNumber()) {
            if (Math.abs(target.getFileName() - source.getFileName()) > 1) {
                result = true;
            } else {
                result = false;
            }
        }
        Assertions.assertTrue(result);
    }

    @Test
    void checkWayToGo_거짓() {
        Location source = new Location("f3");
        Location target = new Location("b8");
        boolean result = false;

        if (source.getFileName() == target.getFileName()) {
            if (Math.abs(target.getRankNumber() - source.getRankNumber()) > 1) {
                result = true;
            } else {
                result = false;
            }
        } else if (source.getRankNumber() == target.getRankNumber()) {
            if (Math.abs(target.getFileName() - source.getFileName()) > 1) {
                result = true;
            } else {
                result = false;
            }
        }
        Assertions.assertFalse(result);
    }
}
