package domain.chess.board;

import domain.chess.board.attribute.File;
import domain.chess.board.attribute.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Location {

    private final String locationTxt;
    private final char fileName;
    private final int rankNumber;
    private static final List<Location> locations = new ArrayList<>();

    public Location(String locationTxt) {
        this.locationTxt = locationTxt;
        this.fileName = locationTxt.charAt(0);
        this.rankNumber = Integer.parseInt(locationTxt.substring(1, 2));
    }

    public static List<Location> getLocations() {
        for (Rank rank : Rank.values()) {
            for (File file : File.values()) {
                locations.add(new Location(file.name() + rank.getNumber()));
            }
        }
        return Collections.unmodifiableList(locations);
    }

    public static Location getLocation(String locationTxt) {
        for (Location location : Location.getLocations()) {
            if (location.getLocation().equals(locationTxt)) {
                return location;
            }
        }
        return null;
    }

    public String getLocation() {
        return locationTxt;
    }

    public char getFileName() {
        return fileName;
    }

    public int getRankNumber() {
        return rankNumber;
    }
}
