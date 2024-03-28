package domain;

import camp.nextstep.edu.missionutils.Console;
import domain.chess.Move;
import domain.chess.board.Checkerboard;
import domain.chess.board.Location;
import domain.user.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

class InputTest {

    @Test
    void 이동_입력_정규식_검사() {
        String line = "move a1 h8";
        boolean result = Pattern.matches("^move\\s([a-h]{1}[1-8]{1})\\s([a-h]{1}[1-8]{1})$", line);
        boolean result2 = !line.split(" ")[1].equals(line.split(" ")[2]);

        Assertions.assertTrue(result);
        Assertions.assertTrue(result2);
    }
}
