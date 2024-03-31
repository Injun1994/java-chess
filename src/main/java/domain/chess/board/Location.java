package domain.chess.board;

import domain.chess.board.attribute.File;
import domain.chess.board.attribute.Rank;

import java.util.*;

public class Location {

    private static final List<Location> locations = new ArrayList<>();

    private final String locationTxt;
    private final char fileName;
    private final int rankNumber;

    public Location(String locationTxt) {
        this.locationTxt = locationTxt;
        this.fileName = locationTxt.charAt(0);
        this.rankNumber = Integer.parseInt(locationTxt.substring(1, 2));
    }

    public static List<Location> getLocations() {
        for (Rank rank : Rank.values()) {
            for (File file : File.values()) {
                locations.add(new Location(file.name().toLowerCase() + rank.getNumber()));
            }
        }
        return Collections.unmodifiableList(locations);
    }

    public static Optional<Location> getLocation(String locationTxt) {
        return Location.getLocations().stream()
                .filter(location -> location.getLocation().equals(locationTxt))
                .findFirst();
    }

    public String getLocation() {
        return locationTxt;
    }

    public Optional<File> getFile() {
        return Arrays.stream(File.values())
                .filter(file -> Character.toLowerCase(file.name().charAt(0)) == fileName)
                .findFirst();
    }

    public char getFileName() {
        return fileName;
    }

    public int getRankNumber() {
        return rankNumber;
    }
}
