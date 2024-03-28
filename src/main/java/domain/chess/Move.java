package domain.chess;

import domain.chess.board.Checkerboard;
import domain.chess.board.Location;
import domain.chess.board.attribute.File;
import domain.chess.board.attribute.Rank;
import domain.chess.piece.*;
import domain.chess.piece.attribute.Symbol;
import domain.chess.piece.attribute.Team;

public class Move {

    public static final String SAME_TEAM_IS_PLACED_ERROR = "[ERROR] 같은 팀이 위치하고 있습니다.";
    public static final String NONE_ERROR = "[ERROR] source에 기말이 없습니다.";
    private final Location source;
    private final Location target;

    public Move(Location source, Location target) {
        this.source = source;
        this.target = target;
    }

    public static boolean isNoPieceOnTheWay(Symbol symbol, Location source, Location target) {
        for (Location location : Checkerboard.positions.keySet()) {
            if (symbol == Symbol.PAWN) {
                return new Pawn().isNoPieceOnTheWay(source, target, location);
            }
        }
        return false;
    }

    public static boolean isDiagonal(Location source, Location target) {
        if (Math.abs(target.getFileName() - source.getFileName()) == Math.abs(target.getRankNumber() - source.getRankNumber())) {
            return true;
        }
        return false;
    }

    public static boolean isInRangeOfFile(char fileName) {
        if (fileName >= File.a.name().charAt(0) && fileName <= File.h.name().charAt(0)) {
            return true;
        }
        return false;
    }

    public static boolean isInRangeOfRank(int rankNumber) {
        if (rankNumber >= Rank.ONE.getNumber() && rankNumber <= Rank.EIGHT.getNumber()) {
            return true;
        }
        return false;
    }

    public void getPiece() {
        char piece = Checkerboard.NONE;
        for (Location location : Checkerboard.positions.keySet()) {
            if (location.getLocation().equals(source.getLocation())) {
                 piece = Checkerboard.positions.get(location);
                 break;
            }
        }
        if (piece == Checkerboard.NONE) {
            throw new RuntimeException(NONE_ERROR);
        } else {
            checkPiece(piece);
        }
    }

    private void checkPiece(char piece) {
        if (Character.toLowerCase(piece) == Symbol.KING.getName(Team.WHITE)) {
            new King().isMoveable(source, target);
        } else if (Character.toLowerCase(piece) == Symbol.QUEEN.getName(Team.WHITE)) {
            new Queen().isMoveable(source, target);
        } else if (Character.toLowerCase(piece) == Symbol.ROOK.getName(Team.WHITE)) {
            new Rook().isMoveable(source, target);
        } else if (Character.toLowerCase(piece) == Symbol.BISHOP.getName(Team.WHITE)) {
            new Bishop().isMoveable(source, target);
        } else if (Character.toLowerCase(piece) == Symbol.KNIGHT.getName(Team.WHITE)) {
            new Knight().isMoveable(source, target);
        } else if (Character.toLowerCase(piece) == Symbol.PAWN.getName(Team.WHITE)) {
            new Pawn().isMoveable(source, target);
        }
    }
}
