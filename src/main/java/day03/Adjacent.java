package day03;

public class Adjacent {

    static boolean isAdjacent(Part part, Symbol symbol) {
        var lhs = part.lhs();
        var rhs = part.rhs();

        var symbolCoord = symbol.coordinate();
        var partCoord = part.coordinate();

        return symbolCoord.x() >= lhs - 1
                && symbolCoord.x() <= rhs + 1
                && symbolCoord.y() >= partCoord.y() - 1
                && symbolCoord.y() <= partCoord.y() + 1;
    }
}
