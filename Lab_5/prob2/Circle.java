package prob2;

/**
 * @author kojusujan1111@gmail.com 26/11/21
 */

public final class Circle implements Figure {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double computeArea() {
        return  Math.PI * this.radius * this.radius;
    }
}
