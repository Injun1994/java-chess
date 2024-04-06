package domain.chess.board;

import domain.chess.piece.attribute.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CheckerboardTest {

    @Test
    void 점이_팀소속으로_참인_경우() {
        Team team = Team.BLACK;
        char piece = '.';
        boolean result = true;

        if (team == Team.getTeam(piece)) {
            result = false;
        }
        Assertions.assertFalse(result);
    }
}
