package domain.chess;

import domain.chess.board.Checkerboard;
import domain.chess.board.Location;

public class MoveDiagonally { // From source To target

    public boolean checkDirection(Location source, Location target) {
        if (source.getFileName() < target.getFileName() && source.getRankNumber() < target.getRankNumber()) {
            return increaseForAll(source, target);
        } else if (source.getFileName() > target.getFileName() && source.getRankNumber() > target.getRankNumber()) {
            return decreaseForAll(source, target);
        } else if (source.getFileName() < target.getFileName() && source.getRankNumber() > target.getRankNumber()) {
            return increaseFileDecreaseRank(source, target);
        } else if (source.getFileName() > target.getFileName() && source.getRankNumber() < target.getRankNumber()) {
            return decreaseFileIncreaseRank(source, target);
        }
        return false;
    }

    public boolean increaseForAll(Location source, Location target) {
        for (int i = 1; i < target.getFileName() - source.getFileName(); i++) {
            char file = (char) (source.getFileName() + i);
            String way = String.valueOf(file) + (source.getRankNumber() + i);
            if (Checkerboard.positions.get(Location.getLocation(way).get()) != Checkerboard.NONE) {
                return false;
            }
        }
        return true;
    }

    public boolean decreaseForAll(Location source, Location target) {
        for (int i = 1; i < source.getFileName() - target.getFileName(); i++) {
            char file = (char) (target.getFileName() + i);
            String way = String.valueOf(file) + (target.getRankNumber() + i);
            if (Checkerboard.positions.get(Location.getLocation(way)) != Checkerboard.NONE) {
                return false;
            }
        }
        return true;
    }

    public boolean increaseFileDecreaseRank(Location source, Location target) {
        for (int i = 1; i <= target.getFileName() - source.getFileName(); i++) {
            char file = (char) (source.getFileName() + i);
            String way = String.valueOf(file) + (source.getRankNumber() - i);
            if (Checkerboard.positions.get(Location.getLocation(way).get()) != Checkerboard.NONE) {
                return false;
            }
        }
        return true;
    }

    public boolean decreaseFileIncreaseRank(Location source, Location target) {
        for (int i = 1; i <= target.getRankNumber() - source.getRankNumber(); i++) {
            char file = (char) (source.getFileName() - i);
            String way = String.valueOf(file) + (source.getRankNumber() + i);
            if (Checkerboard.positions.get(Location.getLocation(way).get()) != Checkerboard.NONE) {
                return false;
            }

        }
        return true;
    }
}
