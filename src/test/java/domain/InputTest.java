package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

class InputTest {

    @Test
    void 이동_입력_정규식_검사_모든조건_참() {
        String line = "move a1 h8";
        boolean result = Pattern.matches(Input.MOVE_COMMAND_REGULAR_EXPRESSION, line);
        boolean result2 = !line.split(" ")[1].equals(line.split(" ")[2]);

        Assertions.assertTrue(result);
        Assertions.assertTrue(result2);
    }

    @Test
    void 이동_입력_정규식_검사_첫번째조건_거짓() {
        String line = "move a0 h9";
        boolean result = Pattern.matches(Input.MOVE_COMMAND_REGULAR_EXPRESSION, line);
        boolean result2 = !line.split(" ")[1].equals(line.split(" ")[2]);

        Assertions.assertFalse(result);
        Assertions.assertTrue(result2);
    }

    @Test
    void 이동_입력_정규식_검사_두번째조건_거짓() {
        String line = "move a1 a1";
        boolean result = Pattern.matches(Input.MOVE_COMMAND_REGULAR_EXPRESSION, line);
        boolean result2 = !line.split(" ")[1].equals(line.split(" ")[2]);

        Assertions.assertTrue(result);
        Assertions.assertFalse(result2);
    }
}
