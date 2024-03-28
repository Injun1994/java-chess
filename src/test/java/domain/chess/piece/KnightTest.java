package domain.chess.piece;

import domain.chess.board.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class KnightTest {

    @Test
    void isMoveable() {
        Location source = new Location("b2");
        Location target = new Location("a4");
        boolean isMoveable = false;

        if (Math.abs(target.getFileName() - source.getFileName()) == Knight.MAX_MOVEABLE_SPACES && Math.abs(target.getRankNumber() - source.getRankNumber()) == Knight.MIN_MOVEABLE_SPACES) {
            isMoveable = true;
        } else if (Math.abs(target.getFileName() - source.getFileName()) == Knight.MIN_MOVEABLE_SPACES && Math.abs(target.getRankNumber() - source.getRankNumber()) == Knight.MAX_MOVEABLE_SPACES) {
            isMoveable = true;
        }
        Assertions.assertTrue(isMoveable);
    }

}
