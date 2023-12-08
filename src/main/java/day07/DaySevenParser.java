package day07;

import solution.Parse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class DaySevenParser implements Parse<List<Hand>> {
    @Override
    public List<Hand> from(InputStream input) {
        var reader = new BufferedReader(new InputStreamReader(input));

        return reader.lines()
                .map(line -> {
                    var split = line.split(" ");
                    var cards = split[0].toCharArray();
                    var bid = Integer.parseInt(split[1]);

                    return new Hand(cards, bid);
                }).toList();
    }
}
