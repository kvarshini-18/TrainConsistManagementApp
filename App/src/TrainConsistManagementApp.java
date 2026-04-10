import java.util.*;

public class TrainConsistManagementApp {


    static boolean linearSearch(String[] bogieIds, String key) {
        for (String id : bogieIds) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC18 - Linear Search (Bogie ID)");
        System.out.println("========================================\n");

        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        String searchKey = "BG309";

        System.out.println("Bogie List: " + Arrays.toString(bogieIds));
        System.out.println("Searching for: " + searchKey);

        boolean found = linearSearch(bogieIds, searchKey);

        if (found) {
            System.out.println("Bogie Found ✅");
        } else {
            System.out.println("Bogie Not Found ❌");
        }

        System.out.println("\nUC18 search completed...");
    }
}