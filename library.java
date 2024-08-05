package Bank;
//Library Managemnet System
import java.util.Arrays;
import java.util.Scanner;

public class library {
    private static String[] books = new String[0];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nBook Manager");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. List All Books");
            System.out.println("4. Sort Books Alphabetically");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title to add: ");
                    String newBook = scanner.nextLine();
                    addBook(newBook);
                    break;
                case 2:
                    System.out.print("Enter book title to remove: ");
                    String bookToRemove = scanner.nextLine();
                    removeBook(bookToRemove);
                    break;
                case 3:
                    listAllBooks();
                    break;
                case 4:
                    sortBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook(String title) {
        books = Arrays.copyOf(books, books.length + 1);
        books[books.length - 1] = title;
        System.out.println("Book added: " + title);
    }

    private static void removeBook(String title) {
        int index = findBook(title);
        if (index != -1) {
            String[] newBooks = new String[books.length - 1];
            for (int i = 0, j = 0; i < books.length; i++) {
                if (i != index) {
                    newBooks[j++] = books[i];
                }
            }
            books = newBooks;
            System.out.println("Book removed: " + title);
        } else {
            System.out.println("Book not found: " + title);
        }
    }

    private static int findBook(String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    private static void listAllBooks() {
        if (books.length == 0) {
            System.out.println("No books in the list.");
        } else {
            System.out.println("Books in the list:");
            for (String book : books) {
                System.out.println(book);
            }
        }
    }

    private static void sortBooks() {
        Arrays.sort(books, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Books sorted alphabetically.");
    }
}
