import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {


    // Method under test (same logic as UC11)
    private boolean validateSafety(List<TrainConsistManagementApp.GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b ->
                        !b.type.equalsIgnoreCase("Cylindrical")
                                || b.cargo.equalsIgnoreCase("Petroleum")
                );
    }


    @Test
    void testSafety_AllBogiesValid() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistManagementApp.GoodsBogie("Open", "Coal"),
                new TrainConsistManagementApp.GoodsBogie("Box", "Grain")
        );

        boolean result = validateSafety(bogies);

        assertTrue(result);
    }


    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal")
        );

        boolean result = validateSafety(bogies);

        assertFalse(result);
    }


    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.GoodsBogie("Open", "Coal"),
                new TrainConsistManagementApp.GoodsBogie("Box", "Grain")
        );

        boolean result = validateSafety(bogies);

        assertTrue(result);
    }


    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal"), // violation
                new TrainConsistManagementApp.GoodsBogie("Open", "Grain")
        );

        boolean result = validateSafety(bogies);

        assertFalse(result);
    }


    @Test
    void testSafety_EmptyBogieList() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = new ArrayList<>();

        boolean result = validateSafety(bogies);

        assertTrue(result); // no violations
    }


    @Test
    void testSafety_AllCylindricalValid() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum")
        );

        boolean result = validateSafety(bogies);

        assertTrue(result);
    }


    @Test
    void testSafety_OriginalListUnchanged() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new TrainConsistManagementApp.GoodsBogie("Open", "Coal"));

        int originalSize = bogies.size();

        boolean result = validateSafety(bogies);

        assertEquals(originalSize, bogies.size()); // unchanged
        assertTrue(result); // still valid
    }
}