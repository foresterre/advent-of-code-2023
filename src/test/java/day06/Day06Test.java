package day06;


import org.junit.jupiter.api.Test;
import solution.Solution;

import static org.assertj.core.api.Assertions.assertThat;

public class Day06Test {
    @Test
    void part1_example() {
        var parser = new DaySixParser();
        var solver = new DaySixSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile(5, "example");

        assertThat(answer).isEqualTo("35");
    }

    @Test
    void part1() {
        var parser = new DaySixParser();
        var solver = new DaySixSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(5);

        // Solution part 1!
        assertThat(answer).isEqualTo("todo");
    }

    @Test
    void part2_example() {
        var parser = new DaySixParser();
        var solver = new DaySixSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile(5, "example");

        assertThat(answer).isEqualTo("todo");
    }

    @Test
    void part2() {
        var parser = new DaySixParser();
        var solver = new DaySixSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(5);

        // Solution part 2!
        assertThat(answer).isEqualTo("todo");
    }
}
