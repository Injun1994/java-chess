package domain.chess.piece.attribute;

public enum Symbol {

    KING('k'),
    QUEEN('q'),
    ROOK('r'),
    BISHOP('b'),
    KNIGHT('n'),
    PAWN('p');

    private char name;

    Symbol(char name) {
        this.name = name;
    }

    public char getName(Team team) {
        if (team == Team.BLACK) {
            return Character.toUpperCase(name);
        }
        return name;
    }
}
