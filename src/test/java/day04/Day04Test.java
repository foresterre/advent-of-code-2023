package day04;

import org.junit.jupiter.api.Test;
import solution.Solution;

import static org.assertj.core.api.Assertions.assertThat;

public class Day04Test {
    @Test
    void part1_example() {
        var parser = new DayFourParser();
        var solver = new DayFourPartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile(4, "example");

        assertThat(answer).isEqualTo("13");
    }

    @Test
    void part1() {
        var parser = new DayFourParser();
        var solver = new DayFourPartOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(4);

        // Solution part 1!
        assertThat(answer).isEqualTo("28750");
    }

    @Test
    void part2_example() {
        var parser = new DayFourParser();
        var solver = new DayFourPartTwoSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile(4, "example");

        assertThat(answer).isEqualTo("30");
    }

    @Test
    void part2() {
        var parser = new DayFourParser();
        var solver = new DayFourPartTwoSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(4);

        // Solution part 2!
        assertThat(answer).isEqualTo("10212704");
    }
}
