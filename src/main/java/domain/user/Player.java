package domain.user;

import domain.chess.board.Checkerboard;
import domain.chess.board.Location;
import domain.chess.board.attribute.File;
import domain.chess.board.attribute.Rank;
import domain.chess.piece.*;

public class Player {

    private static final int EMPTY_POSITION_START_RANK = 3;
    private static final int EMPTY_POSITION_END_RANK = 6;

    public void setDefaultPosition() {
        for (Location location : Location.getLocations()) {
            King.setDefaultPosition(location, Checkerboard.positions);
            Queen.setDefaultPosition(location, Checkerboard.positions);
            Rook.setDefaultPosition(location, Checkerboard.positions);
            Bishop.setDefaultPosition(location, Checkerboard.positions);
            Knight.setDefaultPosition(location, Checkerboard.positions);
            Pawn.setDefaultPosition(location, Checkerboard.positions);
            setEmptyPosition(location);
        }
        Checkerboard.printDefaultCheckerboard(Checkerboard.positions);
    }

    private void setEmptyPosition(Location location) {
        for (File file : File.values()) {
            for (Rank rank : Rank.values()) {
                if (rank.getNumber() >= EMPTY_POSITION_START_RANK && rank.getNumber() <= EMPTY_POSITION_END_RANK) {
                    if (location.getLocation().equals(file.name() + rank.getNumber())) {
                        Checkerboard.positions.put(location, Checkerboard.NONE);
                    }
                }
            }
        }
    }
}
