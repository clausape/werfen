package test.part2;

import part2.PointWithAim;

public class PointWithAimTest {

    public static void main(String[] args) {
        testConstructor();
        testGettersSetters();
        testEquals();
        testHashCode();
        testToString();

        System.out.println("All tests for PointWithAim passed!");
    }

    private static void testConstructor() {
        PointWithAim point = new PointWithAim(3, 4, 90);
        assert 3 == point.getHorizontal() : "Constructor failed to set horizontal value";
        assert 4 == point.getVertical() : "Constructor failed to set vertical value";
        assert 90 == point.getAim() : "Constructor failed to set aim value";
    }

    private static void testGettersSetters() {
        PointWithAim point = new PointWithAim(3, 4, 90);

        point.setHorizontal(5);
        point.setVertical(6);
        point.setAim(180);

        assert 5 == point.getHorizontal() : "Getter or Setter failed for horizontal";
        assert 6 == point.getVertical() : "Getter or Setter failed for vertical";
        assert 180 == point.getAim() : "Getter or Setter failed for aim";
    }

    private static void testEquals() {
        PointWithAim point1 = new PointWithAim(3, 4, 90);
        PointWithAim point2 = new PointWithAim(3, 4, 90);
        PointWithAim point3 = new PointWithAim(5, 6, 45);

        assert point1.equals(point2) : "Equals failed for identical points";
        assert !point1.equals(point3) : "Equals failed for different points";
    }

    private static void testHashCode() {
        PointWithAim point1 = new PointWithAim(3, 4, 90);
        PointWithAim point2 = new PointWithAim(3, 4, 90);

        assert point1.hashCode() == point2.hashCode() : "hashCode failed for identical points";
    }

    private static void testToString() {
        PointWithAim point = new PointWithAim(3, 4, 90);
        String expected = "Point{horizontal=3, vertical=4, aim=90}";
        assert expected.equals(point.toString()) : "toString failed";
    }
}

