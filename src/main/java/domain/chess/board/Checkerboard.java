package domain.chess.board;

import domain.Score;
import domain.chess.Move;
import domain.chess.piece.attribute.Symbol;
import domain.chess.piece.attribute.Team;

import java.util.*;

public class Checkerboard {

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
        removePiece(source, team, target);
    }

    public static boolean isCheckmate(char piece) {
        return Character.toLowerCase(piece) == Symbol.KING.getName(Team.WHITE);
    }
}
