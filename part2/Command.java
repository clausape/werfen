package part2;

public class Command {
    private Movement movement;
    private int distance;

    public Command(Movement movement, int distance) {
        this.movement = movement;
        this.distance = distance;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return distance == command.distance &&
                movement == command.movement;
    }

    @Override
    public int hashCode() {
        int result = movement.hashCode();
        result = 31 * result + Integer.hashCode(distance);
        return result;
    }

    @Override
    public String toString() {
        return "Command{" +
                "movement=" + movement +
                ", distance=" + distance +
                '}';
    }

    public static Command createCommand(String comm) {
        String[] operations = comm.split(" ");
        return new Command(Movement.valueOf(operations[0]), Integer.parseInt(operations[1]));
    }
}

