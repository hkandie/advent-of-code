package aoc;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class Day02Test {

    @Test
    public void shouldAnswerPartOne() {
        Day02 day01 = new Day02();
        day01.partOne();
    }

    @Test
    public void shouldAnswerPartTwo() {
        Day02 day01 = new Day02();
        day01.partTwo();
    }

    @Test
    public void shouldRemoveItem() {
        Day02 day01 = new Day02();
        int[] a = { 1, 2, 3, 4, 5 };
        int[] result = day01.removeItem(a, 0);
        int[] expected = { 2, 3, 4, 5 };
        assertArrayEquals(expected, result);

        int[] result4 = day01.removeItem(a, 4);
        int[] expected4 = { 1, 2, 3, 4 };
        assertArrayEquals(expected4, result4);

    }

}
