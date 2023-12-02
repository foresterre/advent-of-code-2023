package day01;

import org.junit.jupiter.api.Test;
import solution.Solution;

import static org.assertj.core.api.Assertions.assertThat;

class Day01Test {

    @Test
    void part1_example() {
        var parser = new DayOneParser(false);
        var solver = new DayOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile("1_example_part1.txt");

        assertThat(answer).isEqualTo("142");
    }

    @Test
    void part1() {
        var parser = new DayOneParser(false);
        var solver = new DayOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(1);

        // Solution part 1!
        assertThat(answer).isEqualTo("55607");
    }

    @Test
    void part2_example() {
        var parser = new DayOneParser(true);
        var solver = new DayOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runFile("1_example_part2.txt");

        assertThat(answer).isEqualTo("281");
    }

    @Test
    void part2() {
        var parser = new DayOneParser(true);
        var solver = new DayOneSolver();

        var solution = new Solution<>(parser, solver);
        var answer = solution.runDay(1);

        // Solution part 2!
        assertThat(answer).isEqualTo("55291");
    }
}
