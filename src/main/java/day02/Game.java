package day02;

import java.util.List;

public record Game(int gameId, List<Hand> hands) {
    public int power() {
        return hands.stream().reduce(new Hand(0, 0, 0), Hand::max).power();
    }
}
