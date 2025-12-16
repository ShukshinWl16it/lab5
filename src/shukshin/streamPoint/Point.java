package shukshin.streamPoint;
import java.util.Objects;
public class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public String toString() {
        return "{"+x+";"+y+"}";
    }
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Point point = (Point) object;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }
    public int hashCode(){
        return Objects.hash(x, y);
    }
}
