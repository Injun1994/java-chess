package domain.chess;

import domain.chess.board.Location;
import domain.chess.board.attribute.File;
import domain.chess.board.attribute.Rank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MoveTest {

    @Test
    void isDiagonal() {
        boolean result = false;
        Location source = new Location("h2");
        Location target = new Location("b8");

        if (Math.abs(target.getFileName() - source.getFileName()) == Math.abs(target.getRankNumber() - source.getRankNumber())) {
            result = true;
        }
        Assertions.assertTrue(result);
    }

    @Test
    void isInRangeOfFile() {
        boolean result = false;
        char fileName = 'i';
        if (fileName >= Character.toLowerCase(File.A.name().charAt(0)) && fileName <= Character.toLowerCase(File.H.name().charAt(0))) {
            result = true;
        }
        Assertions.assertFalse(result);
    }

    @Test
    void isInRangeOfRank() {
        boolean result = false;
        int rankNumber = 9;
        if (rankNumber >= Rank.ONE.getNumber() && rankNumber <= Rank.EIGHT.getNumber()) {
            result = true;
        }
        Assertions.assertFalse(result);
    }
}
