package domain.chess.board;

import domain.Score;
import domain.chess.Move;
import domain.chess.board.attribute.File;
import domain.chess.board.attribute.Rank;
import domain.chess.piece.attribute.Symbol;
import domain.chess.piece.attribute.Team;

import java.util.*;

public class Checkerboard {

    public static final String CHECKERBOARD_LAST_FILE = "h";
    public static final char NONE = '.';
    public static final Map<Location, Character> positions = new HashMap<>();

    public static void removePiece(Location source, Team team, Location target) {
        char piece = positions.get(target);

        if (team == Team.getTeam(piece) && piece != NONE) {
            throw new RuntimeException(Move.SAME_TEAM_IS_PLACED_ERROR);
        } else {
            positions.put(target, positions.get(source));
            positions.put(source, NONE);
        }
        Score.calculate(team);
        if (isCheckmate(piece)) return;
    }

    public static void isCheckable(Location source, Location target) {
        Team team = Team.getTeam(positions.get(source));
        Checkerboard.removePiece(source, team, target);
    }

    public static void printDefaultCheckerboard(Map<Location, Character> positions) {
        for (Location location : Location.getLocations()) {
            for (Location position : positions.keySet()) {
                matchLocation(location, position);
            }
        }
        System.out.println();
        Arrays.stream(File.values()).forEach(file -> System.out.print(file.name().toLowerCase()));
    }

    public static boolean isCheckmate(char piece) {
        return Character.toLowerCase(piece) == Symbol.KING.getName(Team.WHITE);
    }

    private static void matchLocation(Location sortedLocation, Location position) {
        if (sortedLocation.equals(position)) {
            System.out.print(positions.get(sortedLocation));
            if (sortedLocation.getLocation().contains(CHECKERBOARD_LAST_FILE)) {
                System.out.print(" " + sortedLocation.getRankNumber());
                if (sortedLocation.getRankNumber() == Rank.ONE.getNumber() || sortedLocation.getRankNumber() == Rank.EIGHT.getNumber()) {
                    System.out.print(" (rank " + sortedLocation.getRankNumber() + ")");
                }
                System.out.println();
            }
        }
    }
}
