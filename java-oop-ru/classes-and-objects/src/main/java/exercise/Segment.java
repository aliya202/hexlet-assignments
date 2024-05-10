package exercise;

// BEGIN
public class Segment {
    private Point x;
    private Point y;

    private Point point1 = new Point();
    private Point point2 = new Point();

    public Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Segment() {
    }

    public Point getBeginPoint() {
        return point1;
    }

    public Point getEndPoint() {
        return point2;
    }

    public Point getMidPoint() {
        int point3x = (point1.getX() + point2.getX()) / 2;
        int point3Y = (point1.getY() + point2.getY()) / 2;
        return new Point(point3x, point3Y);
    }
}
// END
