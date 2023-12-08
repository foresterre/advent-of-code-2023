package day04;

import java.util.Set;

public record Card(int id, Set<Integer> winning, Set<Integer> drawn) {
}
