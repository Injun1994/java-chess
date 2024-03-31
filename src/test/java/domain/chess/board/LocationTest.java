package domain.chess.board;

import domain.chess.board.attribute.File;
import domain.chess.board.attribute.Rank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LocationTest {

    @Test
    void getLocation() {
        boolean result = false;
        boolean result2 = false;
        for (Location location : Location.getLocations()) {
            if (location.getLocation().equals("a0")) {
                result = true;
            }
            if (location.getLocation().equals("h8")) {
                result2 = true;
            }
        }
        Assertions.assertFalse(result);
        Assertions.assertTrue(result2);
    }

    @Test
    void getLocations() {
        List<Location> locations = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            for (File file : File.values()) {
                locations.add(new Location(file.name().toLowerCase() + rank.getNumber()));
            }
        }
        assertThat(locations.size()).isEqualTo(64);
    }
}
