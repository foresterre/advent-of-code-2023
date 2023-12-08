package day04;

import com.google.common.collect.Sets;
import solution.Solver;

import java.util.*;
import java.util.stream.Stream;

public class DayFourPartTwoSolver implements Solver<Stream<Card>> {
    @Override
    public String solve(Stream<Card> input) {
        var allCards = input.toList();
        var winCounts = new int[allCards.size()];
        Arrays.fill(winCounts, 1);

        for (int i = 0; i < allCards.size(); i++) {
            var card = allCards.get(i);
            var wins = Sets.intersection(card.drawn(), card.winning()).size();

            // each win adds copies to the next j cards
            for (int j = 1; j <= wins; j++) {
                winCounts[i+j] = winCounts[i+j] + winCounts[i];
            }
        }

        int sum = Arrays.stream(winCounts).sum();
        return String.valueOf(sum);
    }
}
