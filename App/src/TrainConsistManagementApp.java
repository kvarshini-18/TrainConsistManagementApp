import java.util.*;

public class TrainConsistManagementApp {

    // Custom Runtime Exception
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie Class
    static class GoodsBogie {
        String shape;   // Rectangular, Cylindrical
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        // Cargo assignment with try-catch-finally
        void assignCargo(String cargo) {
            try {
                // Rule: Rectangular cannot carry Petroleum
                if (shape.equalsIgnoreCase("Rectangular") &&
                        cargo.equalsIgnoreCase("Petroleum")) {

                    throw new CargoSafetyException(
                            "Unsafe cargo! Petroleum cannot be assigned to Rectangular bogie"
                    );
                }

                this.cargo = cargo;
                System.out.println("Cargo assigned: " + cargo + " to " + shape);

            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                System.out.println("Assignment attempt completed for " + shape);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC15 - Safe Cargo Assignment");
        System.out.println("========================================\n");

        List<GoodsBogie> bogies = new ArrayList<>();

        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        bogies.add(b1);
        bogies.add(b2);

        // Safe assignment
        b1.assignCargo("Petroleum");

        // Unsafe assignment
        b2.assignCargo("Petroleum");

        // Program continues
        b2.assignCargo("Coal");

        System.out.println("\nFinal Bogie State:");
        for (GoodsBogie b : bogies) {
            System.out.println(b.shape + " -> " + b.cargo);
        }

        System.out.println("\nUC15 execution completed...");
    }
}