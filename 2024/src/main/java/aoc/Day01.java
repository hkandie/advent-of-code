package aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class Day01 {
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
        List<String> data = readInput("input/01-1-small.txt");

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
            totalDistance += Math.abs(a.get(j) - b.get(j));
        }
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

            totalDistance += c.size() * a.get(index);
        }
        System.out.println(totalDistance);
    }

}
