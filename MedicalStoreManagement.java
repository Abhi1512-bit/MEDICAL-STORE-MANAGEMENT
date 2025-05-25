import java.util.ArrayList;
import java.util.Scanner;

class Medicine {
    String name;
    int quantity;
    double price;

    Medicine(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.println("Name: " + name + ", Quantity: " + quantity + ", Price: $" + price);
    }
}

public class MedicalStoreManagement {
    static ArrayList<Medicine> inventory = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Medical Store Management ---");
            System.out.println("1. Add Medicine");
            System.out.println("2. Display Medicines");
            System.out.println("3. Search Medicine");
            System.out.println("4. Update Stock");
            System.out.println("5. Sell Medicine");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addMedicine();
                case 2 -> displayMedicines();
                case 3 -> searchMedicine();
                case 4 -> updateStock();
                case 5 -> sellMedicine();
                case 0 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    static void addMedicine() {
        System.out.print("Enter medicine name: ");
        String name = sc.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        inventory.add(new Medicine(name, quantity, price));
        System.out.println("Medicine added successfully!");
    }

    static void displayMedicines() {
        if (inventory.isEmpty()) {
            System.out.println("No medicines available.");
            return;
        }
        System.out.println("\n--- Available Medicines ---");
        for (Medicine med : inventory) {
            med.display();
        }
    }

    static void searchMedicine() {
        System.out.print("Enter medicine name to search: ");
        String name = sc.nextLine();
        boolean found = false;
        for (Medicine med : inventory) {
            if (med.name.equalsIgnoreCase(name)) {
                med.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Medicine not found.");
        }
    }

    static void updateStock() {
        System.out.print("Enter medicine name to update: ");
        String name = sc.nextLine();
        for (Medicine med : inventory) {
            if (med.name.equalsIgnoreCase(name)) {
                System.out.print("Enter new quantity: ");
                med.quantity = sc.nextInt();
                System.out.println("Stock updated successfully.");
                return;
            }
        }
        System.out.println("Medicine not found.");
    }

    static void sellMedicine() {
        System.out.print("Enter medicine name to sell: ");
        String name = sc.nextLine();
        for (Medicine med : inventory) {
            if (med.name.equalsIgnoreCase(name)) {
                System.out.print("Enter quantity to sell: ");
                int qty = sc.nextInt();
                if (qty <= med.quantity) {
                    med.quantity -= qty;
                    double total = qty * med.price;
                    System.out.println("Sold " + qty + " units. Total amount: $" + total);
                } else {
                    System.out.println("Insufficient stock.");
                }
                return;
            }
        }
        System.out.println("Medicine not found.");
    }
}

    
