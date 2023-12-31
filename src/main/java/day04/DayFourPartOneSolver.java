package day04;

import com.google.common.collect.Sets;
import solution.Solver;

import java.util.stream.Stream;

public class DayFourPartOneSolver implements Solver<Stream<Card>> {
    @Override
    public String solve(Stream<Card> input) {
        var sum = input
                .map(card -> Sets.intersection(card.drawn(), card.winning()).size())
                .mapToInt((winCount) -> winCount == 0 ? 0 : (int) Math.pow(2, winCount - 1))
                .sum();


        return String.valueOf(sum);
    }
}
