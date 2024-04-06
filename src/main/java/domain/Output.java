package domain;

import domain.chess.board.Checkerboard;
import domain.chess.board.Location;
import domain.chess.board.attribute.File;
import domain.chess.board.attribute.Rank;
import domain.chess.piece.attribute.Team;

import java.util.Arrays;
import java.util.Map;

public class Output {

    public static final String CHECKERBOARD_LAST_FILE = "h";

    public static void printDefaultCheckerboard(Map<Location, Character> positions) {
        for (Location location : Location.getLocations()) {
            for (Location position : positions.keySet()) {
                matchLocation(location, position);
            }
        }
        System.out.println();
        Arrays.stream(File.values()).forEach(file -> System.out.print(file.name().toLowerCase()));
    }

    public static void printScore(Team team, double score) {
        System.out.println(team.name() + " : " + score);
    }

    private static void matchLocation(Location sortedLocation, Location position) {
        if (sortedLocation.equals(position)) {
            System.out.print(Checkerboard.positions.get(sortedLocation));
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
