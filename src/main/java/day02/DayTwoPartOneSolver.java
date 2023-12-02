package day02;


import solution.Solver;

import java.util.List;

public class DayTwoPartOneSolver implements Solver<List<Game>> {
    @Override
    public String solve(List<Game> log) {
        return String.valueOf(log
                .stream()
                .filter(game -> game.hands().stream().allMatch(hand -> hand.red() <= 12 && hand.green() <= 13 && hand.blue() <= 14))
                .mapToInt(Game::gameId)
                .sum());
    }
}
