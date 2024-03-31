package domain.chess;

import domain.chess.board.Checkerboard;
import domain.chess.board.Location;

public class MoveHorizontalOrVertical {

    public boolean checkWayToGo(Location source, Location target) {
        if (source.getFileName() == target.getFileName()) {
            if (Math.abs(target.getRankNumber() - source.getRankNumber()) > 1) {
                return checkVerticalWay(source, target);
            } else {
                return true;
            }
        } else if (source.getRankNumber() == target.getRankNumber()) {
            if (Math.abs(target.getFileName() - source.getFileName()) > 1) {
                return checkHorizontalWay(source, target);
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean checkHorizontalWay(Location source, Location target) {
        int minNumber = Math.min(source.getFileName(), target.getFileName());

        for (int i = 1; i < Math.abs(target.getFileName() - source.getFileName()); i++) {
            char file = (char) (minNumber + i);
            String way = String.valueOf(file) + source.getRankNumber();
            if (Checkerboard.positions.get(Location.getLocation(way).get()) != Checkerboard.NONE) {
                return false;
            }
        }
        return true;
    }

    public boolean checkVerticalWay(Location source, Location target) {
        int minNumber = Math.min(source.getRankNumber(), target.getRankNumber());

        for (int i = 1; i < Math.abs(target.getRankNumber() - source.getRankNumber()); i++) {
            String way = String.valueOf(source.getFileName()) + (minNumber + i);
            if (Checkerboard.positions.get(Location.getLocation(way).get()) != Checkerboard.NONE) {
                return false;
            }
        }
        return true;
    }
}
