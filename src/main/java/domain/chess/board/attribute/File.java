package domain.chess.board.attribute;

import java.util.stream.Stream;

public enum File {

    a,
    b,
    c,
    d,
    e,
    f,
    g,
    h;

    public static File getFile(char fileName) {
        return Stream.of(File.values())
                .filter(file -> file.name().charAt(0) == fileName)
                .findFirst()
                .orElse(null);
    }
}
