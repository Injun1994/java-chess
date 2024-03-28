package domain.chess.piece.attribute;

public enum Team {

    BLACK,
    WHITE;

    public static Team getTeam(char piece) {
        if (Character.isLowerCase(piece)) {
            return WHITE;
        }
        return BLACK;
    }
}
