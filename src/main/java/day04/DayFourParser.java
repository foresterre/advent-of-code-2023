package day04;

import com.google.common.base.Joiner;
import solution.Parse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DayFourParser implements Parse<Stream<Card>> {
    @Override
    public Stream<Card> from(InputStream input) {
        var reader = new BufferedReader(new InputStreamReader(input));

        return reader.lines()
                .map((line) -> {
                    var card = line.split(": ");
                    var id = card[0].replace("Card", "").trim();

                    var numbers = card[1].split(" \\| ");
                    var winning = numbers[0].trim().split("\\s+");
                    var drawn = numbers[1].trim().split("\\s+");

                    var cardId = Integer.parseInt(id);
                    var winningNums = Arrays.stream(winning).map(Integer::parseInt).collect(Collectors.toSet());
                    var drawnNums = Arrays.stream(drawn).map(Integer::parseInt).collect(Collectors.toSet());

                    return new Card(cardId, winningNums, drawnNums);
                });
    }
}
