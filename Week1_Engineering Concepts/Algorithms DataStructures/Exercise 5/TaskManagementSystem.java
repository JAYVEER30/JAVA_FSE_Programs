import java.util.Scanner;

public class TaskManagementSystem {
    private Task head = null;

    // Add task at end
    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
    }

    // Search task by id
    public Task searchTask(int id) {
        Task current = head;
        while (current != null) {
            if (current.taskId == id) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Delete task by id
    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task with ID " + id + " deleted.");
            return;
        }

        Task current = head;
        while (current.next != null && current.next.taskId != id) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Task not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Task with ID " + id + " deleted.");
        }
    }

    // Display all tasks
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    // === Menu driven main method ===
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManagementSystem system = new TaskManagementSystem();

        system.addTask(1, "Design Homepage", "Pending");
        system.addTask(2, "Implement Login Module", "In Progress");
        system.addTask(3, "Test Payment Gateway", "Pending");
        system.addTask(4, "Fix UI Bugs", "Completed");

        int choice;

        do {
            System.out.println("\n===== Task Management System =====");
            System.out.println("1. Add Task");
            System.out.println("2. Display All Tasks");
            System.out.println("3. Search Task by ID");
            System.out.println("4. Delete Task by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Task Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Task Status: ");
                    String status = scanner.nextLine();
                    system.addTask(id, name, status);
                    break;

                case 2:
                    system.displayTasks();
                    break;

                case 3:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = scanner.nextInt();
                    Task t = system.searchTask(searchId);
                    System.out.println(t != null ? t : "Task not found.");
                    break;

                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    system.deleteTask(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
