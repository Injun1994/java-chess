package domain;

public class Main {

    public static void main(String[] args) {
        Input input = new Input();
        input.inputInfo();
        while (!Input.END_COMMAND.equals(input.inputLine())) ;
    }
}
