import java.util.HashMap;
import java.util.Scanner;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return productId + " - " + productName + " | Qty: " + quantity + " | Price: ₹" + price;
    }
}

public class InventorySystem {
    HashMap<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product, boolean silent) {
        if (inventory.containsKey(product.productId)) {
            if (!silent) System.out.println("Product ID already exists.");
        } else {
            inventory.put(product.productId, product);
            if (!silent) System.out.println("Product added successfully.");
        }
    }

    public void updateProduct(int productId, String name, int qty, double price) {
        if (inventory.containsKey(productId)) {
            Product p = inventory.get(productId);
            p.productName = name;
            p.quantity = qty;
            p.price = price;
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product ID not found.");
        }
    }

    public void deleteProduct(int productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product ID not found.");
        }
    }

    public void displayProducts() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("----- Inventory -----");
            for (Product p : inventory.values()) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventorySystem inv = new InventorySystem();

        inv.addProduct(new Product(101, "Mouse", 50, 299.99), true);
        inv.addProduct(new Product(102, "Keyboard", 30, 499.50), true);
        inv.addProduct(new Product(103, "Monitor", 20, 7999.00), true);
        inv.addProduct(new Product(104, "USB Cable", 100, 149.99), true);

        int choice;

        do {
            System.out.println("\n===== Inventory Menu =====");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            switch (choice) {
                case 1:
                    System.out.println(">>> Add Product Selected");
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    inv.addProduct(new Product(id, name, qty, price), false);
                    break;

                case 2:
                    System.out.println(">>> Update Product Selected");
                    System.out.print("Enter Product ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Quantity: ");
                    int newQty = scanner.nextInt();
                    System.out.print("Enter New Price: ");
                    double newPrice = scanner.nextDouble();
                    inv.updateProduct(updateId, newName, newQty, newPrice);
                    break;

                case 3:
                    System.out.println(">>> Delete Product Selected");
                    System.out.print("Enter Product ID: ");
                    int deleteId = scanner.nextInt();
                    inv.deleteProduct(deleteId);
                    break;

                case 4:
                    System.out.println(">>> Display Products Selected");
                    inv.displayProducts();
                    break;

                case 5:
                    System.out.println("Exiting Inventory System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
