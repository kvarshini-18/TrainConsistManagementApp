import java.util.Scanner;

public class TrainConsistManagementApp {

    // ✅ ADD THESE METHODS (THIS IS WHAT WAS MISSING)
    public static boolean isValidTrainId(String trainId) {
        return trainId != null && trainId.matches("TRN-\\d{4}");
    }

    public static boolean isValidCargoCode(String cargoCode) {
        return cargoCode != null && cargoCode.matches("PET-[A-Z]{2}");
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC11 - Validate Train ID & Cargo Codes");
        System.out.println("========================================\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Train ID: ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code: ");
        String cargoCode = scanner.nextLine();

        boolean isTrainValid = isValidTrainId(trainId);
        boolean isCargoValid = isValidCargoCode(cargoCode);

        if (isTrainValid) {
            System.out.println("Train ID is VALID");
        } else {
            System.out.println("Train ID is INVALID");
        }

        if (isCargoValid) {
            System.out.println("Cargo Code is VALID");
        } else {
            System.out.println("Cargo Code is INVALID");
        }

        System.out.println("\nUC11 validation completed...");
    }
}