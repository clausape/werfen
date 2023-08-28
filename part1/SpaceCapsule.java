package part1;

import java.util.List;
import static java.lang.Math.max;

public class SpaceCapsule {
    private Point point = new Point(0, 0);

    public SpaceCapsule() {}
    public SpaceCapsule(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceCapsule that = (SpaceCapsule) o;
        return point.equals(that.point);
    }

    @Override
    public int hashCode() {
        return point.hashCode();
    }

    @Override
    public String toString() {
        return "SpaceCapsule{" +
                "point=" + point +
                '}';
    }

    private void moveForward(int distance) {
        int currentX = point.getHorizontal();
        point.setHorizontal(currentX + distance);
    }

    private void moveDown(int distance) {
        int currentY = point.getVertical();
        point.setVertical(currentY + distance);
    }

    private void moveUp(int distance) {
        int currentY = point.getVertical();
        point.setVertical(max(currentY - distance, 0));
    }

    public void move(List<String> rawCommands) {
        if (rawCommands == null) {
            throw new IllegalArgumentException("commands must not be null");
        }

        for (String rawCommand : rawCommands) {
            Command command = Command.createCommand(rawCommand);

            switch (command.getMovement()) {
                case forward -> moveForward(command.getDistance());
                case up -> moveUp(command.getDistance());
                case down -> moveDown(command.getDistance());
                default -> throw new IllegalArgumentException("invalid command: " + command.getMovement());
            }
        }
        System.out.println("The space capsule is at (" + point.getHorizontal() + ", " + point.getVertical() + ")");
    }

}