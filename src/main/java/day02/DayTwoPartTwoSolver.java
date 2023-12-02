package day02;


import solution.Solver;

import java.util.List;

public class DayTwoPartTwoSolver implements Solver<List<Game>> {
    @Override
    public String solve(List<Game> log) {
        return String.valueOf(log
                .stream()
                .mapToInt(Game::power)
                .sum());
    }
}
