import java.util.Scanner;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return employeeId + " | " + name + " | " + position + " | ₹" + salary;
    }
}

public class EmployeeManagementSystem {
    private static final int MAX_EMPLOYEES = 100;
    private Employee[] employees = new Employee[MAX_EMPLOYEES];
    private int count = 0;

    public void addEmployee(Employee emp, boolean silent) {
        if (count < MAX_EMPLOYEES) {
            employees[count++] = emp;
            if (!silent) System.out.println("Employee added successfully.");
        } else {
            System.out.println("Cannot add more employees. Array is full.");
        }
    }

    public Employee searchEmployee(int empId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == empId) return employees[i];
        }
        return null;
    }

    public void displayEmployees() {
        if (count == 0) {
            System.out.println("No employees to display.");
            return;
        }
        System.out.println("----- Employee List -----");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(int empId) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == empId) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }
        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[--count] = null;
        System.out.println("Employee with ID " + empId + " deleted.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagementSystem system = new EmployeeManagementSystem();

        system.addEmployee(new Employee(1, "Pravallika", "Manager", 85000), true);
        system.addEmployee(new Employee(2, "Jayveer", "Developer", 65000), true);
        system.addEmployee(new Employee(3, "Satya", "Designer", 55000), true);

        int choice;

        do {
            System.out.println("\n===== Employee Management Menu =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee by ID");
            System.out.println("3. Delete Employee by ID");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            switch (choice) {
                case 1:
                    System.out.println(">>> Add Employee Selected");
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    system.addEmployee(new Employee(id, name, position, salary), false);
                    break;

                case 2:
                    System.out.println(">>> Search Employee Selected");
                    System.out.print("Enter Employee ID: ");
                    int searchId = scanner.nextInt();
                    Employee found = system.searchEmployee(searchId);
                    System.out.println(found != null ? found : "Employee not found.");
                    break;

                case 3:
                    System.out.println(">>> Delete Employee Selected");
                    System.out.print("Enter Employee ID: ");
                    int deleteId = scanner.nextInt();
                    system.deleteEmployee(deleteId);
                    break;

                case 4:
                    System.out.println(">>> Display Employees Selected");
                    system.displayEmployees();
                    break;

                case 5:
                    System.out.println("Exiting Employee Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
