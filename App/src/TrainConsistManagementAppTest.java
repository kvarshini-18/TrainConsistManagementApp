import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    private boolean search(String[] arr, String key) {
        return TrainConsistManagementApp.linearSearch(arr, key);
    }


    @Test
    void testSearch_BogieFound() {
        String[] data = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(search(data, "BG309"));
    }


    @Test
    void testSearch_BogieNotFound() {
        String[] data = {"BG101","BG205","BG309","BG412","BG550"};

        assertFalse(search(data, "BG999"));
    }


    @Test
    void testSearch_FirstElementMatch() {
        String[] data = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(search(data, "BG101"));
    }


    @Test
    void testSearch_LastElementMatch() {
        String[] data = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(search(data, "BG550"));
    }


    @Test
    void testSearch_SingleElementArray() {
        String[] data = {"BG101"};

        assertTrue(search(data, "BG101"));
    }
}