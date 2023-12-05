package day05;


import org.junit.jupiter.api.Test;
import solution.Solution;

import static org.assertj.core.api.Assertions.assertThat;

public class Day05Test {
    @Test
    void part1_example() {
        var parser = new DayFiveParser();
        var solver = new DayFiveSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile("5_example.txt");

        assertThat(answer).isEqualTo("35");
    }

    @Test
    void part1() {
        var parser = new DayFiveParser();
        var solver = new DayFiveSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(5);

        // Solution part 1!
        assertThat(answer).isEqualTo("todo");
    }

    @Test
    void part2_example() {
        var parser = new DayFiveParser();
        var solver = new DayFiveSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile("5_example.txt");

        assertThat(answer).isEqualTo("todo");
    }

    @Test
    void part2() {
        var parser = new DayFiveParser();
        var solver = new DayFiveSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(5);

        // Solution part 2!
        assertThat(answer).isEqualTo("todo");
    }
}
