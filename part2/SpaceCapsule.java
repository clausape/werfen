package part2;

import java.util.List;

import static java.lang.Math.max;

public class SpaceCapsule {
    private PointWithAim pointWithAim = new PointWithAim(0, 0, 0);

    public SpaceCapsule() {}
    public SpaceCapsule(PointWithAim pointWithAim) {
        this.pointWithAim = pointWithAim;
    }

    public PointWithAim getPoint() {
        return pointWithAim;
    }

    public void setPoint(PointWithAim pointWithAim) {
        this.pointWithAim = pointWithAim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceCapsule that = (SpaceCapsule) o;
        return pointWithAim.equals(that.pointWithAim);
    }

    @Override
    public int hashCode() {
        return pointWithAim.hashCode();
    }

    @Override
    public String toString() {
        return "SpaceCapsule{" +
                "point=" + pointWithAim +
                '}';
    }

    private void moveForward(int distance) {
        int currentX = pointWithAim.getHorizontal();
        pointWithAim.setHorizontal(currentX + distance);
        int currentY = pointWithAim.getVertical();
        int currentAim = pointWithAim.getAim();
        pointWithAim.setVertical(currentY + distance*currentAim);
    }

    private void moveDown(int distance) {
        int currentY = pointWithAim.getVertical();
        pointWithAim.setVertical(currentY + distance);
    }

    private void moveUp(int distance) {
        int currentY = pointWithAim.getVertical();
        pointWithAim.setVertical(max(currentY - distance, 0));
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
        System.out.println("The space capsule is at (" + pointWithAim.getHorizontal() + ", " + pointWithAim.getVertical() + ")");
    }

}