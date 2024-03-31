package domain.chess.piece;

import domain.chess.Move;
import domain.chess.board.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BishopTest {

    @ParameterizedTest
    @CsvSource(value = {"c1:h8", "c3:h4"}, delimiter = ':')
    void isMoveable_참(String sourceTxt, String targetTxt) {
        Location source = new Location(sourceTxt);
        Location target = new Location(targetTxt);
        boolean result = Move.isDiagonal(source, target);
        Assertions.assertFalse(result);
    }
}
