import java.util.*;
import java.util.stream.*;

public class TrainConsistManagementApp {


    static class GoodsBogie {
        String type;   // Cylindrical, Open, Box
        String cargo;  // Petroleum, Coal, Grain

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC12 - Safety Compliance Check");
        System.out.println("========================================\n");


        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));



        System.out.println("Goods Bogies:");
        for (GoodsBogie b : bogies) {
            System.out.println(b.type + " -> " + b.cargo);
        }


        boolean isSafe = bogies.stream()
                .allMatch(b ->
                        !b.type.equalsIgnoreCase("Cylindrical")
                                || b.cargo.equalsIgnoreCase("Petroleum")
                );


        System.out.println("\nSafety Status:");
        if (isSafe) {
            System.out.println("Train is SAFE for operation");
        } else {
            System.out.println("Train is NOT SAFE! Rule violation detected");
        }

        System.out.println("\nUC12 safety check completed...");
    }
}