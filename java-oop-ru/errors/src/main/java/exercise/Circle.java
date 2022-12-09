package exercise;

// BEGIN
public class Circle {
    private final Point centre;
    private final int radius;

    public Circle(Point point, int radius) {
        this.centre = new Point(point.getX(), point.getY());
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (getRadius() < 0) {
            throw new NegativeRadiusException("");
        }

        return Math.PI * getRadius() * getRadius();
    }
}
// END
