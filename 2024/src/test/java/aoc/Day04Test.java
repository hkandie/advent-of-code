package aoc;

import org.junit.jupiter.api.Test;

public class Day04Test {
    String sampleName = "input/04-small.txt";
    String inputName = "input/04-input.txt";

    @Test
    public void shouldAnswerPartOne() {
        Day04 day04 = new Day04();
        day04.partOne(sampleName);
    }

    @Test
    public void shouldAnswerPartTwo() {
        Day04 day04 = new Day04();
        day04.partTwo();
    }

    @Test
    public void shouldfindDiagonal() {
        Day04 day04 = new Day04();
        day04.findDiagonal(sampleName);
    }
}