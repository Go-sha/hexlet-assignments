package exercise;

// BEGIN
public class Segment {
    private Point beginPoint;
    private Point endPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Point getBeginPoint() {
        return this.beginPoint;
    }

    public Point getEndPoint() {
        return this.endPoint;
    }

    public Point getMidPoint() {
        int midPointX = (this.endPoint.getX() + this.beginPoint.getX()) / 2;
        int midPointY = (this.endPoint.getY() + this.beginPoint.getY()) / 2;
        return new Point(midPointX, midPointY);
    }
}
// END
