package aoc;

import org.junit.jupiter.api.Test;

public class Day03Test {
    String sampleName = "input/03-small.txt";
    String inputName = "input/03-input.txt";

    @Test
    public void shouldEvaluate() {
        Day03 day03 = new Day03();
        day03.evaluate("mul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))");
    }
    @Test
    public void shouldEvaluatePart2() {
        Day03 day03 = new Day03();
        day03.evaluatePartTwo("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))");
    }

    @Test
    public void shouldAnswerPartOne() {
        Day03 day03 = new Day03();
        day03.partOne(sampleName);
        day03.partOne(inputName);
    }

    @Test
    public void shouldAnswerPartTwo() {
        Day03 day03 = new Day03();
        day03.partTwo(sampleName);
        day03.partTwo(inputName);
    }
    // 71387892 
    // 90669332    // 91155532
    // 17871048    // 17871048
    // 2:48307573    // 48307573
    // 2:77412620    // 77411126
    // 21838475    // 21838475
    // 1017684    // 1017684
}