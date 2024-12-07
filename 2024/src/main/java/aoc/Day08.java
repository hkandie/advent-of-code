package aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day08 {
    String sampleName = "08-small.txt";
    String inputName ="08-input.txt";

    List<String> readInput(String path) {

        // Define the directory and file path
        Path directoryPath = Paths.get(path);

        try {
            List<String> data = Files.readAllLines(directoryPath);

            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    void partOne() {
        System.out.println("Day 08, Part 1");
    }

    void partTwo() {
        System.out.println("Day 08, Part 2");
    }
}
