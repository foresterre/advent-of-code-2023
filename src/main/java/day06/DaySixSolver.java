package day06;

import solution.Solver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class DaySixSolver implements Solver<List<Race>> {
    @Override
    public String solve(List<Race> input) {
        var mult = input.stream()
                .mapToLong((race) -> LongStream.rangeClosed(0, race.time())
                        .map(power -> {
                            var timeRemaining = race.time() - power /* button hold time */;

                            return power /* speed */ * timeRemaining;
                        })
                        .filter(attemptedDistance -> attemptedDistance > race.recordDistance())
                        .count()).reduce(1, (acc, next) -> acc * next);


        return String.valueOf(mult);
    }
}
