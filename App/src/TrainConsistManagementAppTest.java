import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {


    private List<TrainConsistManagementApp.Bogie> filter(List<TrainConsistManagementApp.Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }


    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("A", 80),
                new TrainConsistManagementApp.Bogie("B", 60)
        );

        List<TrainConsistManagementApp.Bogie> result = filter(bogies, 70);

        assertEquals(1, result.size());
        assertEquals("A", result.get(0).name);
    }


    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("A", 70)
        );

        List<TrainConsistManagementApp.Bogie> result = filter(bogies, 70);

        assertTrue(result.isEmpty());
    }


    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("A", 50)
        );

        List<TrainConsistManagementApp.Bogie> result = filter(bogies, 70);

        assertTrue(result.isEmpty());
    }


    @Test
    void testFilter_MultipleBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("A", 80),
                new TrainConsistManagementApp.Bogie("B", 90),
                new TrainConsistManagementApp.Bogie("C", 50)
        );

        List<TrainConsistManagementApp.Bogie> result = filter(bogies, 70);

        assertEquals(2, result.size());
    }


    @Test
    void testFilter_NoBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("A", 40),
                new TrainConsistManagementApp.Bogie("B", 50)
        );

        List<TrainConsistManagementApp.Bogie> result = filter(bogies, 70);

        assertTrue(result.isEmpty());
    }


    @Test
    void testFilter_AllBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("A", 80),
                new TrainConsistManagementApp.Bogie("B", 90)
        );

        List<TrainConsistManagementApp.Bogie> result = filter(bogies, 70);

        assertEquals(2, result.size());
    }


    @Test
    void testFilter_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        List<TrainConsistManagementApp.Bogie> result = filter(bogies, 70);

        assertTrue(result.isEmpty());
    }


    @Test
    void testFilter_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("A", 80));
        bogies.add(new TrainConsistManagementApp.Bogie("B", 50));

        int originalSize = bogies.size();

        List<TrainConsistManagementApp.Bogie> result = filter(bogies, 70);

        assertEquals(originalSize, bogies.size()); // unchanged
        assertEquals(1, result.size()); // filtered result
    }
}