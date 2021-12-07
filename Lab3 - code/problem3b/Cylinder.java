
public class Cylinder {
    private Circle circle;
    private double height;

    public Cylinder() {
    }

    public Cylinder(double radius) {
        this.circle = new Circle(radius);
    }

    public Cylinder(double radius, double height) {
        this.circle = new Circle(radius);
        this.height = height;
    }

    public Circle getCircle() {
        return circle;
    }

    public double getHeight() {
        return this.height;
    }

    public double getVolume() {
        return  Math.PI * Math.pow(this.circle.getRadius(), 2) * height;
    }
}
