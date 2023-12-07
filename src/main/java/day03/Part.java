package day03;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.Objects;

public class Part  {
    // Left most x, y coordinate
    private final Coordinate coordinate;
    private final ArrayList<Character> numberComponents;

    public Part(int x, int y, char token) {
        this.coordinate = new Coordinate(x, y);
        this.numberComponents = new ArrayList<>();
        this.numberComponents.add(token);
    }

    public void addNumberComponent(char c) {
        this.numberComponents.add(c);
    }

    public boolean isAdjacent(Symbol symbol) {
        return Adjacent.isAdjacent(this, symbol);
    }

    public int partNumber() {
        var s = Joiner.on("").join(this.numberComponents);
        return Integer.parseInt(s);
    }


    public int lhs() {
        return this.coordinate.x();
    }

    public int rhs() {
        return this.coordinate.x() + this.numberComponents.size() - 1;
    }

    public Coordinate coordinate() {
        return coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part cell = (Part) o;
        return Objects.equals(coordinate, cell.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }
}
