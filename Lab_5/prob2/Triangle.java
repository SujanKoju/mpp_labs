package prob2;

/**
 * @author kojusujan1111@gmail.com 26/11/21
 */

public final class Triangle implements Figure {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double computeArea() {
        return 0.5*this.base*this.height;
    }
}
