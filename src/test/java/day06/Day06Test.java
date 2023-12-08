package day06;


import org.junit.jupiter.api.Test;
import solution.Solution;

import static org.assertj.core.api.Assertions.assertThat;

public class Day06Test {
    @Test
    void part1_example() {
        var parser = new DaySixPartOneParser();
        var solver = new DaySixSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile(6, "example");

        assertThat(answer).isEqualTo("288");
    }

    @Test
    void part1() {
        var parser = new DaySixPartOneParser();
        var solver = new DaySixSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(6);

        // Solution part 1!
        assertThat(answer).isEqualTo("316800");
    }

    @Test
    void part2_example() {
        var parser = new DaySixPartTwoParser();
        var solver = new DaySixSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile(6, "example");

        assertThat(answer).isEqualTo("71503");
    }

    @Test
    void part2() {
        var parser = new DaySixPartTwoParser();
        var solver = new DaySixSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(6);

        // Solution part 2!
        assertThat(answer).isEqualTo("45647654");
    }
}
