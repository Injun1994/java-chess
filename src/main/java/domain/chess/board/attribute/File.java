package domain.chess.board.attribute;

public enum File {

    A('a'),
    B('b'),
    C('c'),
    D('d'),
    E('e'),
    F('f'),
    G('g'),
    H('h');

    private final char fileName;

    File(char fileName) {
        this.fileName = fileName;
    }

    public char getFileName() {
        return fileName;
    }
}
