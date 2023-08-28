package part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        String filePath = "files/instructions.txt";

        try {
            List<String> commands = Files.readAllLines(Paths.get(filePath));
            SpaceCapsule spaceCapsule = new SpaceCapsule();
            spaceCapsule.move(commands);

        } catch (IOException e) {
            System.out.println("wrong file");
            e.printStackTrace();
        }
    }
}
