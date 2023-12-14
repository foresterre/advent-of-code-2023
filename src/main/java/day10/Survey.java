package day10;

import java.util.List;
import java.util.Map;

public record Survey(Map<Vertex, List<Vertex>> graph, Vertex start, String[] grid) {
    private static final StringBuilder sb = new StringBuilder();

    public Survey {
        for (String line : grid) {
            for (int x = 0; x < line.length(); x++) {
                var cell = line.charAt(x);

                switch (cell) {
                    case 'S' -> sb.append("S");
                    case '|' -> sb.append("│");
                    case '-' -> sb.append("─");
                    case 'L' -> sb.append("└");
                    case 'J' -> sb.append("┘");
                    case '7' -> sb.append("┐");
                    case 'F' -> sb.append("┌");
                    default -> sb.append(cell);
                }
            }
            sb.append(System.lineSeparator());
        }
    }

    public void markInside(Vertex vertex) {
        mark(vertex.x(), vertex.y(), 'I');
    }

    public void markOutside(Vertex vertex) {
        mark(vertex.x(), vertex.y(), 'O');
    }

    public void markChar(Vertex vertex, char c) {
        mark(vertex.x(), vertex.y(), c);
    }

    private void mark(int x, int y, char c) {
        int lengthOfLines = grid[y].length() + System.lineSeparator().length();
        int index = y * lengthOfLines + x;

        sb.setCharAt(index, c);
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
