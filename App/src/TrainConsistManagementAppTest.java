import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {


    private Map<String, List<TrainConsistManagementApp.Bogie>> groupBogies(List<TrainConsistManagementApp.Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }


    @Test
    void testGrouping_BogiesGroupedByType() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("Sleeper", 70)
        );

        Map<String, List<TrainConsistManagementApp.Bogie>> result = groupBogies(bogies);

        assertEquals(1, result.size());
        assertTrue(result.containsKey("Sleeper"));
    }


    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("AC Chair", 56),
                new TrainConsistManagementApp.Bogie("AC Chair", 60)
        );

        Map<String, List<TrainConsistManagementApp.Bogie>> result = groupBogies(bogies);

        assertEquals(2, result.get("AC Chair").size());
    }


    @Test
    void testGrouping_DifferentBogieTypes() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 56),
                new TrainConsistManagementApp.Bogie("First Class", 24)
        );

        Map<String, List<TrainConsistManagementApp.Bogie>> result = groupBogies(bogies);

        assertEquals(3, result.size());
    }


    @Test
    void testGrouping_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        Map<String, List<TrainConsistManagementApp.Bogie>> result = groupBogies(bogies);

        assertTrue(result.isEmpty());
    }


    @Test
    void testGrouping_SingleBogieCategory() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("Sleeper", 70)
        );

        Map<String, List<TrainConsistManagementApp.Bogie>> result = groupBogies(bogies);

        assertEquals(1, result.size());
    }


    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 56),
                new TrainConsistManagementApp.Bogie("First Class", 24)
        );

        Map<String, List<TrainConsistManagementApp.Bogie>> result = groupBogies(bogies);

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }


    @Test
    void testGrouping_GroupSizeValidation() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("Sleeper", 70),
                new TrainConsistManagementApp.Bogie("AC Chair", 56)
        );

        Map<String, List<TrainConsistManagementApp.Bogie>> result = groupBogies(bogies);

        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC Chair").size());
    }


    @Test
    void testGrouping_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));

        int originalSize = bogies.size();

        Map<String, List<TrainConsistManagementApp.Bogie>> result = groupBogies(bogies);

        assertEquals(originalSize, bogies.size()); // original unchanged
        assertEquals(2, result.size()); // grouped result
    }
}