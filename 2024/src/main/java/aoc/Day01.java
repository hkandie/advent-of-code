package aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class Day01 {
    String sampleName = "input";

    void readInput() {

        // Define the directory and file path
        Path directoryPath = Paths.get("input/01-1-input.txt");

        try {
            List<String> data = Files.readAllLines(directoryPath);

            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            data.forEach(d -> {
                List<String> ab = Arrays.asList(d.split(" ")).stream().filter((i -> i != "")).toList();

                a.add(Integer.parseInt(ab.get(0)));
                b.add(Integer.parseInt(ab.get(1)));
            });
            a.sort(null);
            b.sort(null);
            int totalDistance = 0;
            for (int j = 0; j < a.size(); j++) {
                totalDistance +=Math.abs(totalDistance);
            }
            System.out.println(totalDistance);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
