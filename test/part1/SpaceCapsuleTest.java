package test.part1;

import part1.Point;
import part1.SpaceCapsule;

import java.util.Arrays;
import java.util.List;

public class SpaceCapsuleTest {

    public static void main(String[] args) {
        testConstructors();
        testGettersSetters();
        testEquals();
        testHashCode();
        testToString();
        testMoveMethod();

        System.out.println("All tests for SpaceCapsule passed!");
    }

    private static void testConstructors() {
        SpaceCapsule capsule1 = new SpaceCapsule();
        assert new Point(0, 0).equals(capsule1.getPoint()) : "Default constructor failed";

        Point p = new Point(5, 6);
        SpaceCapsule capsule2 = new SpaceCapsule(p);
        assert p.equals(capsule2.getPoint()) : "Parameterized constructor failed";
    }

    private static void testGettersSetters() {
        SpaceCapsule capsule = new SpaceCapsule();
        Point newPoint = new Point(7, 8);
        capsule.setPoint(newPoint);

        assert newPoint.equals(capsule.getPoint()) : "Getter or Setter failed";
    }

    private static void testEquals() {
        SpaceCapsule capsule1 = new SpaceCapsule(new Point(3, 4));
        SpaceCapsule capsule2 = new SpaceCapsule(new Point(3, 4));
        SpaceCapsule capsule3 = new SpaceCapsule(new Point(5, 6));

        assert capsule1.equals(capsule2) : "Equals failed for identical capsules";
        assert !capsule1.equals(capsule3) : "Equals failed for different capsules";
    }

    private static void testHashCode() {
        SpaceCapsule capsule1 = new SpaceCapsule(new Point(3, 4));
        SpaceCapsule capsule2 = new SpaceCapsule(new Point(3, 4));

        assert capsule1.hashCode() == capsule2.hashCode() : "hashCode failed for identical capsules";
    }

    private static void testToString() {
        SpaceCapsule capsule = new SpaceCapsule(new Point(3, 4));
        String expected = "SpaceCapsule{point=Point{horizontal=3, vertical=4}}";
        assert expected.equals(capsule.toString()) : "toString failed";
    }

    private static void testMoveMethod() {
        SpaceCapsule capsule = new SpaceCapsule(new Point(0, 0));

        List<String> commands = Arrays.asList("forward 5", "up 3", "down 2");
        capsule.move(commands);

        assert new Point(5, 1).equals(capsule.getPoint()) : "Move method failed";
    }
}
