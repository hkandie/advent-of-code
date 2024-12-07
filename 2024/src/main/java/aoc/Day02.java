package aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Hello world!
 */
public class Day02 {
    String sampleName = "input/01-2-input.txt";

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
        List<String> data = readInput(sampleName);

        AtomicInteger totalDistance = new AtomicInteger(0);
        for (int i = 0; i < data.size(); i++) {
            int[] ab = Arrays.stream(data.get(i).split(" "))
                    .filter(j -> !j.isEmpty())
                    .mapToInt(Integer::parseInt)
                    .toArray();

            boolean areAllDecreasing = IntStream.range(0, ab.length - 1).allMatch(j -> ab[j] <= ab[j + 1]);
            boolean areAllIncreasing = IntStream.range(0, ab.length - 1).allMatch(j -> ab[j] >= ab[j + 1]);
            boolean isAdjuscent = IntStream.range(0, ab.length - 1)
                    .allMatch(j -> {
                        int difference = Math.abs(ab[j] - ab[j + 1]);
                        return difference >= 1 && difference <= 3;
                    });

            if (isAdjuscent && (areAllDecreasing || areAllIncreasing)) {
                totalDistance.getAndIncrement();
            }

        }
        System.out.printf("Total: [%d]\n", totalDistance.get());
    }

    int[] removeItem(int[] arr, int index) {

        int[] anotherArray = new int[arr.length - 1];
        for (int i = 0, k = 0; i <= arr.length - 1; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }

    boolean isSafe(int[] ab) {
        boolean isAllDecreasing = IntStream.range(0, ab.length - 1).allMatch(j -> ab[j] <= ab[j + 1]);
        boolean areAllIncreasing = IntStream.range(0, ab.length - 1).allMatch(j -> ab[j] >= ab[j + 1]);
        boolean isAllAdjuscent = IntStream.range(0, ab.length - 1)
                .allMatch(j -> {
                    int difference = Math.abs(ab[j] - ab[j + 1]);
                    return difference >= 1 && difference <= 3;
                });
        return isAllAdjuscent && (isAllDecreasing || areAllIncreasing);
    }

    void partTwo() {

        List<String> data = readInput(sampleName);

        AtomicInteger safeCounter = new AtomicInteger(0);
        for (int i = 0; i < data.size(); i++) {
            int[] ab = Arrays.stream(data.get(i).split(" "))
                    .filter(j -> !j.isEmpty())
                    .mapToInt(Integer::parseInt)
                    .toArray();
            boolean valid = isSafe(ab);

            if (valid) {
                safeCounter.getAndIncrement();
            }
            if (!valid) {
                for (int k = 0; k < ab.length; k++) {
                    int[] temp = removeItem(ab, k);

                    boolean isValidWithDampaner = isSafe(temp);

                    if (isValidWithDampaner) {
                        safeCounter.getAndIncrement();
                        break;
                    }

                }
            }

        }
        System.out.printf("Total: [%d]\n", safeCounter.get());
    }

}
