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
    private Piece piece;

    public Move(Location source, Location target) {
        this.source = source;
        this.target = target;
    }

    private void setPiece(char pieceTxt) {
        if (Character.toLowerCase(pieceTxt) == Symbol.KING.getName(Team.WHITE)) {
            this.piece = new King();
        } else if (Character.toLowerCase(pieceTxt) == Symbol.QUEEN.getName(Team.WHITE)) {
            this.piece = new Queen();
        } else if (Character.toLowerCase(pieceTxt) == Symbol.ROOK.getName(Team.WHITE)) {
            this.piece = new Rook();
        } else if (Character.toLowerCase(pieceTxt) == Symbol.BISHOP.getName(Team.WHITE)) {
            this.piece = new Bishop();
        } else if (Character.toLowerCase(pieceTxt) == Symbol.KNIGHT.getName(Team.WHITE)) {
            this.piece = new Knight();
        } else if (Character.toLowerCase(pieceTxt) == Symbol.PAWN.getName(Team.WHITE)) {
            this.piece = new Pawn();
        } else {
            throw new RuntimeException(NONE_ERROR);
        }
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
        if (fileName >= File.A.getFileName() && fileName <= File.H.getFileName()) {
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
        char pieceTxt = Checkerboard.NONE;
        for (Location location : Checkerboard.positions.keySet()) {
            if (location.getLocation().equals(source.getLocation())) {
                pieceTxt = Checkerboard.positions.get(location);
                 break;
            }
        }
        setPiece(pieceTxt);
        checkPiece(piece);
    }

    private boolean checkPiece(Piece piece) {
        return piece.isMoveable(source, target);
    }
}
