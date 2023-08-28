package test.part2;

import part2.PointWithAim;
import part2.SpaceCapsule;

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
        assert new PointWithAim(0, 0, 0).equals(capsule1.getPoint()) : "Default constructor failed";

        PointWithAim p = new PointWithAim(5, 6, 90);
        SpaceCapsule capsule2 = new SpaceCapsule(p);
        assert p.equals(capsule2.getPoint()) : "Parameterized constructor failed";
    }

    private static void testGettersSetters() {
        SpaceCapsule capsule = new SpaceCapsule();
        PointWithAim newPoint = new PointWithAim(7, 8, 45);
        capsule.setPoint(newPoint);

        assert newPoint.equals(capsule.getPoint()) : "Getter or Setter failed";
    }

    private static void testEquals() {
        SpaceCapsule capsule1 = new SpaceCapsule(new PointWithAim(3, 4, 90));
        SpaceCapsule capsule2 = new SpaceCapsule(new PointWithAim(3, 4, 90));
        SpaceCapsule capsule3 = new SpaceCapsule(new PointWithAim(5, 6, 45));

        assert capsule1.equals(capsule2) : "Equals failed for identical capsules";
        assert !capsule1.equals(capsule3) : "Equals failed for different capsules";
    }

    private static void testHashCode() {
        SpaceCapsule capsule1 = new SpaceCapsule(new PointWithAim(3, 4, 90));
        SpaceCapsule capsule2 = new SpaceCapsule(new PointWithAim(3, 4, 90));

        assert capsule1.hashCode() == capsule2.hashCode() : "hashCode failed for identical capsules";
    }

    private static void testToString() {
        SpaceCapsule capsule = new SpaceCapsule(new PointWithAim(3, 4, 90));
        String expected = "SpaceCapsule{point=Point{horizontal=3, vertical=4, aim=90}}";
        assert expected.equals(capsule.toString()) : "toString failed";
    }

    private static void testMoveMethod() {
        SpaceCapsule capsule = new SpaceCapsule(new PointWithAim(0, 0, 1));

        List<String> commands = Arrays.asList("forward 5", "up 3", "down 2");
        capsule.move(commands);

        assert new PointWithAim(5, 5, 1).equals(capsule.getPoint()) : "Move method failed";
    }
}

