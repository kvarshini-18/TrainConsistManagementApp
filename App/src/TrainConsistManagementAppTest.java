import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {


    private int calculateTotalSeats(List<TrainConsistManagementApp.Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }


    @Test
    void testReduce_TotalSeatCalculation() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC", 56)
        );

        int total = calculateTotalSeats(bogies);

        assertEquals(128, total);
    }


    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("A", 10),
                new TrainConsistManagementApp.Bogie("B", 20),
                new TrainConsistManagementApp.Bogie("C", 30)
        );

        int total = calculateTotalSeats(bogies);

        assertEquals(60, total);
    }


    @Test
    void testReduce_SingleBogieCapacity() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Single", 50)
        );

        int total = calculateTotalSeats(bogies);

        assertEquals(50, total);
    }


    @Test
    void testReduce_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        int total = calculateTotalSeats(bogies);

        assertEquals(0, total);
    }


    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("A", 5),
                new TrainConsistManagementApp.Bogie("B", 15)
        );

        int total = calculateTotalSeats(bogies);

        assertEquals(20, total);
    }


    @Test
    void testReduce_AllBogiesIncluded() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("A", 10),
                new TrainConsistManagementApp.Bogie("B", 20),
                new TrainConsistManagementApp.Bogie("C", 30),
                new TrainConsistManagementApp.Bogie("D", 40)
        );

        int total = calculateTotalSeats(bogies);

        assertEquals(100, total);
    }


    @Test
    void testReduce_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("A", 10));
        bogies.add(new TrainConsistManagementApp.Bogie("B", 20));

        int originalSize = bogies.size();

        int total = calculateTotalSeats(bogies);

        assertEquals(originalSize, bogies.size()); // unchanged
        assertEquals(30, total); // correct result
    }
}