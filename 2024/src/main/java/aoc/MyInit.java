package aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Hello world!
 */
public class MyInit {
    String sampleName = "input";

    void readInput() {

        // Define the directory and file path
        Path directoryPath = Paths.get("input");

        try {
            // Create the directories if they don't exist
            if (Files.notExists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }
            LocalDateTime myDateObj = LocalDateTime.of(2024, 12, 1, 0, 0);
            for (int i = 0; i < 25; i++) {
                // Create the file if it doesn't exist
                String name = myDateObj.plus(i, ChronoUnit.DAYS).format(DateTimeFormatter.ofPattern("dd"));
                Files.createFile(directoryPath.resolve(name+"-1-small.txt"));
                Files.createFile(directoryPath.resolve(name+"-1-input.txt"));
                Files.createFile(directoryPath.resolve(name+"-2-small.txt"));
                Files.createFile(directoryPath.resolve(name+"-2-input.txt"));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
