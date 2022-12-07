package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public int compareTO(Home another) {
        if (another.getArea() < this.getArea()) {
            return 1;
        } else if (another.getArea() > this.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return floorCount + " этажный коттедж площадью " + this.area + " метров";
    }
}
// END
