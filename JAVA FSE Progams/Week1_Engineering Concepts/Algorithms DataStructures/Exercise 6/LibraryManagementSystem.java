import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return bookId + " | " + title + " by " + author;
    }
}

public class LibraryManagementSystem {

    public static Book linearSearch(Book[] books, String searchTitle) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(searchTitle)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String searchTitle) {
        Book[] sortedBooks = Arrays.copyOf(books, books.length);
        Arrays.sort(sortedBooks, Comparator.comparing(b -> b.title.toLowerCase()));

        int low = 0, high = sortedBooks.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = sortedBooks[mid].title.compareToIgnoreCase(searchTitle);
            if (cmp == 0) return sortedBooks[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }

        return null;
    }

    public static void displayBooks(Book[] books) {
        if (books.length == 0) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("----- Library Books -----");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Book[] books = {
            new Book(1, "The Hobbit", "J.R.R. Tolkien"),
            new Book(2, "1984", "George Orwell"),
            new Book(3, "Pride and Prejudice", "Jane Austen"),
            new Book(4, "To Kill a Mockingbird", "Harper Lee"),
            new Book(5, "Moby-Dick", "Herman Melville")
        };

        int choice;

        do {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Linear Search by Title");
            System.out.println("2. Binary Search by Title");
            System.out.println("3. Display All Books");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            switch (choice) {
                case 1:
                    System.out.println(">>> Linear Search Selected");
                    System.out.print("Enter book title to search: ");
                    String linearTitle = scanner.nextLine();
                    Book found1 = linearSearch(books, linearTitle);
                    System.out.println(found1 != null ? found1 : "Book not found.");
                    break;

                case 2:
                    System.out.println(">>> Binary Search Selected");
                    System.out.print("Enter book title to search: ");
                    String binaryTitle = scanner.nextLine();
                    Book found2 = binarySearch(books, binaryTitle);
                    System.out.println(found2 != null ? found2 : "Book not found.");
                    break;

                case 3:
                    System.out.println(">>> Display Books Selected");
                    displayBooks(books);
                    break;

                case 4:
                    System.out.println("Exiting Library System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
