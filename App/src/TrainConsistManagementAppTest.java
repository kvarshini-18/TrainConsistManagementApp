import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {


    @Test
    void testException_ValidCapacityCreation() {
        assertDoesNotThrow(() -> {
            TrainConsistManagementApp.PassengerBogie bogie =
                    new TrainConsistManagementApp.PassengerBogie("Sleeper", 72);

            assertEquals("Sleeper", bogie.type);
            assertEquals(72, bogie.capacity);
        });
    }


    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("AC", -10)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }


    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("First Class", 0)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }


    @Test
    void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("Test", 0)
        );

        assertTrue(exception.getMessage().contains("greater than zero"));
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }


    @Test
    void testException_ObjectIntegrityValidation() throws Exception {
        TrainConsistManagementApp.PassengerBogie bogie =
                new TrainConsistManagementApp.PassengerBogie("AC Chair", 56);

        assertEquals("AC Chair", bogie.type);
        assertEquals(56, bogie.capacity);
    }
}