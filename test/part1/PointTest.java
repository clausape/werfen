package test.part1;

import part1.Point;

public class PointTest {

    public static void main(String[] args) {
        testConstructor();
        testGetters();
        testSetters();
        testEquals();
        testHashCode();
        testToString();

        System.out.println("All tests passed!");
    }

    private static void testConstructor() {
        Point point = new Point(3, 4);
        assert 3 == point.getHorizontal() : "Constructor failed to set horizontal value";
        assert 4 == point.getVertical() : "Constructor failed to set vertical value";
    }

    private static void testGetters() {
        Point point = new Point(5, 6);
        assert 5 == point.getHorizontal() : "Getter failed for horizontal value";
        assert 6 == point.getVertical() : "Getter failed for vertical value";
    }

    private static void testSetters() {
        Point point = new Point(3, 4);
        point.setHorizontal(7);
        point.setVertical(8);
        assert 7 == point.getHorizontal() : "Setter failed for horizontal value";
        assert 8 == point.getVertical() : "Setter failed for vertical value";
    }

    private static void testEquals() {
        Point point1 = new Point(3, 4);
        Point point2 = new Point(3, 4);
        Point point3 = new Point(5, 6);

        assert point1.equals(point2) : "Equals failed for identical points";
        assert !point1.equals(point3) : "Equals failed for different points";
    }

    private static void testHashCode() {
        Point point1 = new Point(3, 4);
        Point point2 = new Point(3, 4);
        assert point1.hashCode() == point2.hashCode() : "hashCode failed for identical points";
    }

    private static void testToString() {
        Point point = new Point(3, 4);
        String expected = "Point{horizontal=3, vertical=4}";
        assert expected.equals(point.toString()) : "toString failed";
    }
}

