package day03;

import solution.Parse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class DayThreeParser implements Parse<PartGrid> {
    private final Set<Part> parts = new HashSet<>();
    private final Set<Symbol> symbols = new HashSet<>();

    private Part lastPartPiece = null;

    @Override
    public PartGrid from(InputStream input) {
        var reader = new BufferedReader(new InputStreamReader(input));
        var lines = reader.lines().toList();

        for (int i = 0; i < lines.size(); i++) {
            var chars = lines.get(i).toCharArray();

            for (int j = 0; j < chars.length; j++) {
                var token = chars[j];

                if (token == '.') {
                    eatEmpty();
                } else if (Character.isDigit(token)) {
                    eatDigit(j, i, token);
                } else {
                    eatSymbol(j, i, token);
                }
            }

            reset();

        }

        return new PartGrid(parts, symbols);
    }

    private void reset() {
        lastPartPiece = null;
    }

    private void eatEmpty() {
        if (lastPartPiece != null) {
            lastPartPiece = null;
        }
    }

    private void eatDigit(int x, int y, char token) {
        if (lastPartPiece != null) {
            lastPartPiece.addNumberComponent(token);
        } else {
            lastPartPiece = new Part(x, y, token);
            parts.add(lastPartPiece);
        }
    }

    private void eatSymbol(int x, int y, char token) {
        if (lastPartPiece != null) {
            lastPartPiece = null;
        }

        symbols.add(new Symbol(new Coordinate(x, y), token));
    }
}
