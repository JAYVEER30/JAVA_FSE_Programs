class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderID: " + orderId + " | Customer: " + customerName + " | Total: $" + totalPrice;
    }
}

public class SortOrders {

    // Bubble Sort by totalPrice

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Quick Sort by totalPrice

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    // Display all orders
    public static void displayOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Alice", 350.0),
            new Order(2, "Bob", 150.5),
            new Order(3, "Charlie", 780.99),
            new Order(4, "David", 120.0),
            new Order(5, "Eva", 450.0)
        };

        // Clone original array
        Order[] ordersForBubble = orders.clone();
        Order[] ordersForQuick = orders.clone();

        // Bubble Sort
        System.out.println("🔹 Orders Sorted by Bubble Sort:");
        bubbleSort(ordersForBubble);
        displayOrders(ordersForBubble);

        // Quick Sort
        System.out.println("\n🔹 Orders Sorted by Quick Sort:");
        quickSort(ordersForQuick, 0, ordersForQuick.length - 1);
        displayOrders(ordersForQuick);
    }
}
