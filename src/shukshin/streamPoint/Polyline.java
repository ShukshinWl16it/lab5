package shukshin.streamPoint;

import java.util.*;
import java.util.stream.Collectors;

public class Polyline {
    private final List<Point> points;

    public Polyline(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    @Override
    public String toString() {
        String pointsStr = points.stream().map(Point::toString).collect(Collectors.joining(","));
        return String.format("Линия ["+ pointsStr+"]");
    }

    public static Polyline createPolyline(List<Point> points) {
        List<Point> processedPoints = points.stream().map(p -> new Point(p.getX(), Math.abs(p.getY()))).distinct().sorted(Comparator.comparingDouble(Point::getX)).collect(Collectors.toList());
        return new Polyline(processedPoints);
    }
}
