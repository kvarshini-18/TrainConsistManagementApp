import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class TrainConsistManagementAppTest {

    private int[] sort(int[] arr) {
        TrainConsistManagementApp.bubbleSort(arr);
        return arr;
    }


    @Test
    void testSort_BasicSorting() {
        int[] input = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};

        assertArrayEquals(expected, sort(input));
    }


    @Test
    void testSort_AlreadySortedArray() {
        int[] input = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};

        assertArrayEquals(expected, sort(input));
    }


    @Test
    void testSort_DuplicateValues() {
        int[] input = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};

        assertArrayEquals(expected, sort(input));
    }


    @Test
    void testSort_SingleElementArray() {
        int[] input = {50};
        int[] expected = {50};

        assertArrayEquals(expected, sort(input));
    }


    @Test
    void testSort_AllEqualValues() {
        int[] input = {40, 40, 40};
        int[] expected = {40, 40, 40};

        assertArrayEquals(expected, sort(input));
    }
}