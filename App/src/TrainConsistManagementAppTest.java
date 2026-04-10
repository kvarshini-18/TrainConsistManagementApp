import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testCargo_SafeAssignment() {
        TrainConsistManagementApp.GoodsBogie bogie =
                new TrainConsistManagementApp.GoodsBogie("Cylindrical");

        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));

        assertEquals("Petroleum", bogie.cargo);
    }


    @Test
    void testCargo_UnsafeAssignmentHandled() {
        TrainConsistManagementApp.GoodsBogie bogie =
                new TrainConsistManagementApp.GoodsBogie("Rectangular");

        // No crash expected because exception is caught internally
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));

        // Cargo should NOT be assigned
        assertNull(bogie.cargo);
    }


    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        TrainConsistManagementApp.GoodsBogie bogie =
                new TrainConsistManagementApp.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.cargo); // remains unassigned
    }


    @Test
    void testCargo_ProgramContinuesAfterException() {
        TrainConsistManagementApp.GoodsBogie bogie =
                new TrainConsistManagementApp.GoodsBogie("Rectangular");

        // First attempt fails
        bogie.assignCargo("Petroleum");

        // Second attempt succeeds
        bogie.assignCargo("Coal");

        assertEquals("Coal", bogie.cargo);
    }


    @Test
    void testCargo_FinallyBlockExecution() {
        TrainConsistManagementApp.GoodsBogie bogie =
                new TrainConsistManagementApp.GoodsBogie("Rectangular");

        // We cannot directly assert finally block print,
        // but we ensure method completes without interruption

        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }
}