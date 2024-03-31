package domain.chess.piece;

import domain.Score;
import domain.chess.Move;
import domain.chess.board.Checkerboard;
import domain.chess.board.Location;
import domain.chess.board.attribute.File;
import domain.chess.piece.attribute.Symbol;
import domain.chess.piece.attribute.Team;

import java.util.Map;
import java.util.Optional;

public class Pawn implements Piece {

    public static final int BLACK_DEFAULT_LOCATION_ALL_RANK = 7;
    public static final int WHITE_DEFAULT_LOCATION_ALL_RANK = 2;
    public static final int FIRST_MOVEABLE_SPACES = 2;
    public static final int MAX_MOVEABLE_SPACES = 1;
    public static final char BLANK = ' ';

    public static void setDefaultPosition(Location location, Map<Location, Character> positions) {
        for (File file : File.values()) {
            if (location.getLocation().equals(file.name().toLowerCase() + BLACK_DEFAULT_LOCATION_ALL_RANK)) {
                positions.put(location, Symbol.PAWN.getName(Team.BLACK));
            } else if (location.getLocation().equals(file.name().toLowerCase() + WHITE_DEFAULT_LOCATION_ALL_RANK)) {
                positions.put(location, Symbol.PAWN.getName(Team.WHITE));
            }
        }
    }

    @Override
    public boolean isMoveable(Location source, Location target) {
        boolean isMoveable = false;
        if (!isMovingForward(source, target)) {
            return false;
        }

        if (target.getFileName() == source.getFileName() && Math.abs(target.getRankNumber() - source.getRankNumber()) == MAX_MOVEABLE_SPACES) {
            isMoveable = true;
        }
        if (source.getRankNumber() == BLACK_DEFAULT_LOCATION_ALL_RANK || source.getRankNumber() == WHITE_DEFAULT_LOCATION_ALL_RANK) {
            isMoveable = isMoveableAtFirst(source, target);
        }
        if (isMoveable && Move.isNoPieceOnTheWay(Symbol.PAWN, source, target)) {
            isCheckable(source, target);
        }
        return isMoveable;
    }

    public boolean isNoPieceOnTheWay(Location source, Location target, Location position) {
        int minNumber = Math.min(source.getRankNumber(), target.getRankNumber());
        int maxNumber = Math.max(source.getRankNumber(), target.getRankNumber());

        for (int rank = minNumber; rank <= maxNumber; rank++) {
            if (!position.getLocation().equals(source.getLocation()) && position.getRankNumber() == rank && position.getFileName() == source.getFileName()) {
                if (Checkerboard.positions.get(position) != Checkerboard.NONE) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isMovingForward(Location source, Location target) {
        Team team = Team.getTeam(Checkerboard.positions.get(source));
        if (team == Team.BLACK && source.getRankNumber() > target.getRankNumber()) {
            return true;
        } else if (team == Team.WHITE && source.getRankNumber() < target.getRankNumber()) {
            return true;
        }
        return false;
    }

    private boolean isMoveableAtFirst(Location source, Location target) {
        if (target.getFileName() == source.getFileName() && Math.abs(target.getRankNumber() - source.getRankNumber()) <= FIRST_MOVEABLE_SPACES) {
            return true;
        }
        return false;
    }

    private void isCheckable(Location source, Location target) {
        Team team = Team.getTeam(Checkerboard.positions.get(source));
        int rankNumber;
        Optional<Location> realTarget = null;
        if (team == Team.BLACK) {
            rankNumber = target.getRankNumber() - MAX_MOVEABLE_SPACES;
        } else {
            rankNumber = target.getRankNumber() + MAX_MOVEABLE_SPACES;
        }
        char realTargetFileName = chooseDirection(target, rankNumber);
        if (realTargetFileName != BLANK) {
            realTarget = Location.getLocation(String.valueOf(realTargetFileName) + rankNumber);
        }
        removePiece(source, team, target, realTarget);
    }

    private char chooseDirection(Location target, int rankNumber) {
        char realTargetFileName = BLANK;

        if (Move.isInRangeOfFile((char) (target.getFileName() - MAX_MOVEABLE_SPACES)) && Move.isInRangeOfRank(rankNumber)) {
            realTargetFileName = getFileName(String.valueOf((char) (target.getFileName() - MAX_MOVEABLE_SPACES)) + rankNumber);
        }
        if (realTargetFileName == BLANK && Move.isInRangeOfFile((char) (target.getFileName() + MAX_MOVEABLE_SPACES)) && Move.isInRangeOfRank(rankNumber)) {
            realTargetFileName = getFileName(String.valueOf((char) (target.getFileName() + MAX_MOVEABLE_SPACES)) + rankNumber);
        }
        return realTargetFileName;
    }

    private char getFileName(String locationTxt) {
        Optional<Location> location = Location.getLocation(locationTxt);
        if (location.isPresent() && Checkerboard.positions.get(location.get()) != Checkerboard.NONE) {
            return locationTxt.charAt(0);
        }
        return BLANK;
    }

    private void removePiece(Location source, Team team, Location target, Optional<Location> realTarget) {
        char piece = Checkerboard.NONE;
        if (realTarget != null) {
            piece = Checkerboard.positions.get(realTarget.get());
        }
        if (piece == Checkerboard.NONE || team == Team.getTeam(piece)) {
            Checkerboard.positions.put(target, Checkerboard.positions.get(source));
        } else {
            Checkerboard.positions.put(realTarget.get(), Checkerboard.positions.get(source));
        }
        Checkerboard.positions.put(source, Checkerboard.NONE);
        Score.calculate(team);
        if (Checkerboard.isCheckmate(piece)) return;
    }
}
