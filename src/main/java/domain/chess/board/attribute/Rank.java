package domain.chess.board.attribute;

public enum Rank {

    EIGHT(8),
    SEVEN(7),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2),
    ONE(1);

    private int number;

    Rank(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
