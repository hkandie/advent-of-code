package aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 {

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
        List<String> data = readInput(inputName);
        int results = 0;
        for (String line : data) {
            List<String> occurrences = evaluate(line);
            for (String occurrence : occurrences) {
                int[] mul = Arrays.stream(occurrence.split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                results += mul[0] * mul[1];
            }
        }

        System.out.println("Day 03, Part 1: " + results);
    }

    void partTwo(String inputName) {
        List<String> data = readInput(inputName);
        String oneLong = String.join("", data);
        int results = 0;
        List<String> occurrences = evaluatePartTwo(oneLong);
        for (String occurrence : occurrences) {
            int[] mul = Arrays.stream(occurrence.split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            results += mul[0] * mul[1];
        }

        System.out.println("Day 03, Part 2:" + results);
    }

    public List<String> evaluate(String input) {

        String regex = "mul\\((\\d+),(\\d+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> occurrences = new ArrayList<>();
        while (matcher.find()) {
            occurrences.add(matcher.group().replaceAll("mul\\(", "").replaceAll("\\)", ""));
        }
        return occurrences;

    }

    public List<String> evaluatePartTwo(String input) {
        String enabledList = "";
        String[] parts = input.split("do\\(\\)");
        for (String part : parts) {
            if (part.contains("don't()")) {
                String[] partWithDont = part.split("don't\\(\\)");
                enabledList += partWithDont[0];
            } else {
                enabledList += part;
            }
        }

        return evaluate(enabledList);

    }
}
