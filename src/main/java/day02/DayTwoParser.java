package day02;

import solution.Parse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class DayTwoParser implements Parse<List<Game>> {
    private Game parseGame(String input) {
        String[] parts = input.split(":", 2);
        String game = parts[0].replace("Game", "").trim();
        int gameId = Integer.parseInt(game);

        List<Hand> hands = parseHands(parts[1]);

        return new Game(gameId, hands);
    }

    private List<Hand> parseHands(String input) {
        var hands = input.split(";");

        return Arrays.stream(hands)
                .map(this::parseHand)
                .toList();
    }

    private Hand parseHand(String input) {
        var colors = input.trim().split(",");

        return Arrays.stream(colors)
                .map(this::parseSingleColor)
                .reduce(new Hand(0, 0, 0), Hand::add);
    }

    private Hand parseSingleColor(String input) {
        String[] parts = input.trim().split(" ");

        int amount = Integer.parseInt(parts[0]);
        String color = parts[1];

        return switch (color) {
            case "red" -> new Hand(amount, 0, 0);
            case "green" -> new Hand(0, amount, 0);
            case "blue" -> new Hand(0, 0, amount);
            default -> new Hand(0, 0, 0);
        };
    }

    @Override
    public List<Game> from(InputStream input) {
        var reader = new BufferedReader(new InputStreamReader(input));

        return reader.lines()
                .map(this::parseGame)
                .toList();
    }
}
