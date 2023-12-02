package day02;

public record Hand(int red, int green, int blue) {
    public Hand add(Hand hand) {
        return new Hand(this.red + hand.red, this.green + hand.green, this.blue + hand.blue);
    }

    public Hand max(Hand hand) {
        return new Hand(
                Math.max(this.red(), hand.red()),
                Math.max(this.green(), hand.green()),
                Math.max(this.blue(), hand.blue())
        );
    }

    public int power() {
        return this.red * this.green * this.blue;
    }
}
