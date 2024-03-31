package domain;

import domain.chess.board.Checkerboard;
import domain.user.Player;

public class Main {

    public static void main(String[] args) {
        Input input = new Input();
        input.inputInfo();
        while (true) {
            String line = input.readLine();
            if (Input.START_COMMAND.equals(line)) {
                new Player().setDefaultPosition();
            } else if (Input.STATUS_COMMAND.equals(line)) {
                Checkerboard.printDefaultCheckerboard(Checkerboard.positions);
            } else if (Input.END_COMMAND.equals(line)) {
                break;
            } else {
                input.inputLine(line);
            }
        }
    }
}
