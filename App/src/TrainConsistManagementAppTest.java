import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    // Loop-based filtering
    private List<TrainConsistManagementApp.Bogie> filterUsingLoop(List<TrainConsistManagementApp.Bogie> bogies) {
        List<TrainConsistManagementApp.Bogie> result = new ArrayList<>();
        for (TrainConsistManagementApp.Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream-based filtering
    private List<TrainConsistManagementApp.Bogie> filterUsingStream(List<TrainConsistManagementApp.Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }


    @Test
    void testLoopFilteringLogic() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("A", 50),
                new TrainConsistManagementApp.Bogie("B", 70),
                new TrainConsistManagementApp.Bogie("C", 60),
                new TrainConsistManagementApp.Bogie("D", 80)
        );

        List<TrainConsistManagementApp.Bogie> result = filterUsingLoop(bogies);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }


    @Test
    void testStreamFilteringLogic() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("A", 40),
                new TrainConsistManagementApp.Bogie("B", 65),
                new TrainConsistManagementApp.Bogie("C", 90)
        );

        List<TrainConsistManagementApp.Bogie> result = filterUsingStream(bogies);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }


    @Test
    void testLoopAndStreamResultsMatch() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("A", 50),
                new TrainConsistManagementApp.Bogie("B", 70),
                new TrainConsistManagementApp.Bogie("C", 90)
        );

        List<TrainConsistManagementApp.Bogie> loopResult = filterUsingLoop(bogies);
        List<TrainConsistManagementApp.Bogie> streamResult = filterUsingStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }


    @Test
    void testExecutionTimeMeasurement() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("A", 50),
                new TrainConsistManagementApp.Bogie("B", 70)
        );

        long start = System.nanoTime();
        filterUsingStream(bogies);
        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
    }


    @Test
    void testLargeDatasetProcessing() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 50 + (i % 100)));
        }

        List<TrainConsistManagementApp.Bogie> loopResult = filterUsingLoop(bogies);
        List<TrainConsistManagementApp.Bogie> streamResult = filterUsingStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());
        assertTrue(loopResult.size() > 0);
    }
}