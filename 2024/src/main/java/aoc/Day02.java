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
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Hello world!
 */
public class Day02 {
    String sampleName = "input";

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
        List<String> data = readInput("input/01-2-input.txt");

        AtomicInteger totalDistance = new AtomicInteger(0);
        data.forEach(d -> {
            List<String> ab = Arrays.asList(d.split(" ")).stream().filter((i -> i != "")).toList();
            boolean toomuch = true;
            int prev = 0;
            for (int i = 0; i < ab.size() - 1; i++) {
                int difference = Math.abs(Integer.parseInt(ab.get(i + 1)) - Integer.parseInt(ab.get(i)));
                if (difference > 2) {
                    toomuch = false;
                    break;
                }
                if (prev > 0 && difference < 0) {
                    toomuch = false;
                    break;
                }
                if (prev < 0 && difference > 0) {
                    toomuch = false;
                    break;
                }
                prev = difference;

            }
            if (toomuch) {
                totalDistance.incrementAndGet();
            }

        });
        System.out.println(totalDistance);

    }

    void partTwo() {

        List<String> data = readInput("input/01-1-input.txt");

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        data.forEach(d -> {
            List<String> ab = Arrays.asList(d.split(" ")).stream().filter((i -> i != "")).toList();

            a.add(Integer.parseInt(ab.get(0)));
            b.add(Integer.parseInt(ab.get(1)));
        });

        int totalDistance = 0;
        for (int j = 0; j < a.size(); j++) {
            final int index = j;
            List<Integer> c = b.stream().filter(num -> num.equals(a.get(index))).toList();
            if (c.size() > 0) {
                System.out.printf("[%d] found %d\n", j, a.get(index), c.size(), c.size() * a.get(index));
            }
            totalDistance += c.size() * a.get(index);
        }
        System.out.println(totalDistance);
    }

}
