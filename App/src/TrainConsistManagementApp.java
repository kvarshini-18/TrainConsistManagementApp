import java.util.*;
import java.util.stream.*;

public class TrainConsistManagementApp {


    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC10 - Count Total Seats Using reduce()");
        System.out.println("========================================\n");


        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));


        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }


        int totalSeats = bogies.stream()
                .map(b -> b.capacity)     // extract capacity
                .reduce(0, Integer::sum); // sum all values


        System.out.println("\nTotal Seating Capacity: " + totalSeats);

        System.out.println("\nUC10 aggregation completed...");
    }
}