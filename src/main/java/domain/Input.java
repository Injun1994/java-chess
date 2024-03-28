package domain;

import camp.nextstep.edu.missionutils.Console;
import domain.chess.Move;
import domain.chess.board.Checkerboard;
import domain.chess.board.Location;
import domain.user.Player;

public class Input {

    public static final String START_COMMAND = "start";
    public static final String END_COMMAND = "end";
    public static final String MOVE_COMMAND_REGULAR_EXPRESSION = "^move\\s([a-h]{1}[1-8]{1})\\s([a-h]{1}[1-8]{1})$";
    public static final String STATUS_COMMAND = "status";
    public static final String START_INFO = "> 체스 게임을 시작합니다.";
    public static final String START_INPUT_INFO = "> 게임 시작 : " + START_COMMAND;
    public static final String END_INPUT_INFO = "> 게임 종료 : " + END_COMMAND;
    public static final String MOVE_INPUT_INFO = "> 게임 이동 : move source위치 target위치 - 예. move b2 b3";
    public static final String INPUT_ERROR_MESSAGE = "[ERROR] start, end, move(예. move b2 b3) 를 입력하세요.";

    public void inputInfo() {
        System.out.println(START_INFO);
        System.out.println(START_INPUT_INFO);
        System.out.println(END_INPUT_INFO);
        System.out.println(MOVE_INPUT_INFO);
        inputLine();
    }

    public String inputLine() {
        String line = readLine();
        try {
            validateInput(line);
        } catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.getStackTrace();
        } catch (RuntimeException runtimeException) {
            runtimeException.getStackTrace();
        }
        return line;
    }

    private String readLine() {
        return Console.readLine();
    }

    private void validateInput(String line) {
        if (START_COMMAND.equals(line)) {
            new Player().setDefaultPosition();
        } else if (END_COMMAND.equals(line)) {
            return;
        } else if (line.matches(MOVE_COMMAND_REGULAR_EXPRESSION) && !line.split(" ")[1].equals(line.split(" ")[2])) {
            new Move(Location.getLocation(line.split(" ")[1]), Location.getLocation(line.split(" ")[2])).getPiece();
        } else if (STATUS_COMMAND.equals(line)) {
            Checkerboard.printDefaultCheckerboard(Checkerboard.positions);
        } else {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }
}
