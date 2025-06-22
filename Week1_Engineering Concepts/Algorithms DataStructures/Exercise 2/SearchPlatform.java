import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return productId + ": " + productName + " [" + category + "]";
    }
}

public class SearchPlatform {

    public static Product linearSearch(Product[] products, String targetName) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(targetName)) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String targetName) {
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(targetName);
            if (cmp == 0) return products[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Phone", "Electronics"),
            new Product(103, "Shoes", "Apparel"),
            new Product(104, "Book", "Stationery"),
            new Product(105, "Watch", "Accessories")
        };

        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        int choice;
        do {
            System.out.println("\n===== Product Search Platform =====");
            System.out.println("1. Linear Search by Product Name");
            System.out.println("2. Binary Search by Product Name");
            System.out.println("3. Display All Products");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            switch (choice) {
                case 1:
                    System.out.println(">>> Linear Search Selected");
                    System.out.print("Enter product name to search: ");
                    String linearTarget = scanner.nextLine();
                    Product linearResult = linearSearch(products, linearTarget);
                    System.out.println(linearResult != null ? linearResult : "Product not found.");
                    break;

                case 2:
                    System.out.println(">>> Binary Search Selected");
                    System.out.print("Enter product name to search: ");
                    String binaryTarget = scanner.nextLine();
                    Product binaryResult = binarySearch(products, binaryTarget);
                    System.out.println(binaryResult != null ? binaryResult : "Product not found.");
                    break;

                case 3:
                    System.out.println(">>> Display Products Selected");
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;

                case 4:
                    System.out.println("Exiting Search Platform. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
