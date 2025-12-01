package aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day04 {

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

    void partOne(String inputName) {
        String xmas = "XMAS";
        List<String> data = readInput(inputName);
        int result = 0;
        for (String line : data) {
            if (line.contains(xmas)) {
                result++;
                System.out.println(line);
            }
            String reversed = new StringBuilder(line).reverse().toString();
            if (reversed.contains(xmas)) {
                result++;
                System.out.println(line);
            }

        }
        List<String> horizontals = findDiagonal(inputName);
        for (String line : horizontals) {
            if (line.contains(line)) {
                result++;
                System.out.println(line);
            }
            String reversed = new StringBuilder(line).reverse().toString();
            if (reversed.contains(xmas)) {
                result++;
                System.out.println(line);
            }

        }

        System.out.println("Day 04, Part 1:" + result);
    }

    void partTwo() {
        System.out.println("Day 04, Part 2");
    }

    String findAt(List<String> data, int x, int y) {
        try {
            return data.get(x).charAt(y) + "";
        } catch (Exception e) {
            return "";
        }

    }

    List<String> findDiagonal(String inputName) {
        List<String> data = readInput(inputName);
        List<String> allDiagonal = new ArrayList<>();
        for (int y = 0; y < data.size(); y++) {
            String diagonal = "";
            for (int x = 0; x < data.size(); x++) {
                diagonal += findAt(data, x, y);
            }

            System.out.println(diagonal);
           

        }

        return allDiagonal;

    }
}
