package domain;

import domain.chess.board.Checkerboard;
import domain.chess.board.Location;
import domain.chess.board.attribute.File;
import domain.chess.piece.attribute.Symbol;
import domain.chess.piece.attribute.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Score {

    private static final int QUEEN_SCORE = 9;
    private static final int ROOK_SCORE = 5;
    private static final int BISHOP_SCORE = 3;
    private static final double KNIGHT_SCORE = 2.5;
    private static final int PAWN_SCORE = 1;
    private static final double PAWN_SCORE_AT_SAME_FILE = 0.5;

    public static void calculate(Team team) {
        double score = 0;
        List<File> pawns = new ArrayList<>();
        for (Location location : Checkerboard.positions.keySet()) {
            char piece = Checkerboard.positions.get(location);
            if (Symbol.QUEEN.getName(team) == piece) {
                score += QUEEN_SCORE;
            } else if (Symbol.ROOK.getName(team) == piece) {
                score += ROOK_SCORE;
            } else if (Symbol.BISHOP.getName(team) == piece) {
                score += BISHOP_SCORE;
            } else if (Symbol.KNIGHT.getName(team) == piece) {
                score += KNIGHT_SCORE;
            } else if (Symbol.PAWN.getName(team) == piece) {
                pawns.add(location.getFile().get());
            }
        }
        Output.printScore(team, score + getScoreOfPawns(pawns));
    }

    private static double getScoreOfPawns(List<File> pawns) {
        double score = 0;
        Map<File, List<File>> groupedList = pawns.stream()
                .collect(Collectors.groupingBy(Function.identity()));

        for (File file : groupedList.keySet()) {
            if (groupedList.get(file).size() > 1) {
                score += (PAWN_SCORE_AT_SAME_FILE * groupedList.get(file).size());
            } else {
                score += PAWN_SCORE;
            }
        }
        return score;
    }
}
