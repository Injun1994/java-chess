package domain.chess.piece;

import domain.chess.Move;
import domain.chess.board.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BishopTest {

    @Test
    void isMoveable() {
        Location source = new Location("c1");
        Location target = new Location("a3");
        boolean result = Move.isDiagonal(source, target);
        Assertions.assertTrue(result);
    }
}
