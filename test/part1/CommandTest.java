package test.part1;

import part1.Command;
import part1.Movement;

public class CommandTest {

    public static void main(String[] args) {
        testConstructor();
        testSetMovement();
        testSetDistance();
        testEquals();
        testToString();
        testCreateCommand();

        System.out.println("All tests passed!");
    }

    private static void testConstructor() {
        Command command = new Command(Movement.up, 5);
        assert Movement.up == command.getMovement() : "Movement not set correctly in constructor";
        assert 5 == command.getDistance() : "Distance not set correctly in constructor";
    }

    private static void testSetMovement() {
        Command command = new Command(Movement.up, 5);
        command.setMovement(Movement.down);
        assert Movement.down == command.getMovement() : "setMovement failed";
    }

    private static void testSetDistance() {
        Command command = new Command(Movement.up, 5);
        command.setDistance(10);
        assert 10 == command.getDistance() : "setDistance failed";
    }

    private static void testEquals() {
        Command command1 = new Command(Movement.up, 5);
        Command command2 = new Command(Movement.up, 5);
        Command command3 = new Command(Movement.down, 5);

        assert command1.equals(command2) : "equals method failed for equal commands";
        assert !command1.equals(command3) : "equals method failed for unequal commands";
    }

    private static void testToString() {
        Command command = new Command(Movement.up, 5);
        String expected = "Command{movement=up, distance=5}";
        assert expected.equals(command.toString()) : "toString failed";
    }

    private static void testCreateCommand() {
        Command command = Command.createCommand("up 5");
        assert Movement.up == command.getMovement() : "createCommand failed for movement";
        assert 5 == command.getDistance() : "createCommand failed for distance";
    }
}
