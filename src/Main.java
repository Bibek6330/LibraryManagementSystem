import java.util.Scanner;

public class Main {
    private static Admin admin;
    private static Library library;

    public static void main(String[] args) {
        initializeSystem();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Library Management System!");

        // Admin login
        System.out.print("Enter admin username: ");
        String adminUsername = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String adminPassword = scanner.nextLine();

        if (admin.authenticate(adminUsername, adminPassword)) {
            System.out.println("Admin login successful.\n");

            // Library operations
            performLibraryOperations(scanner);
        } else {
            System.out.println("Admin login failed. Exiting the system.");
        }
    }

    private static void initializeSystem() {
        // Initialize admin
        admin = new Admin("admin", "admin123");

        // Initialize library
        library = new Library();
        library.addBook(new Book(1, "Harry potter"));
        library.addBook(new Book(2, "Power of Your Subconscious Mind"));
        library.addBook(new Book(3, "Rich Dad Poor Dad"));
        // Add more books as needed
    }

    private static void performLibraryOperations(Scanner scanner) {
        int choice;
        do {
            System.out.println("Library Operations:");
            System.out.println("1. Display Available Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayAvailableBooks();
                    break;
                case 2:
                    borrowBook(scanner);
                    break;
                case 3:
                    returnBook(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void borrowBook(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        User user = new User(username, password);

        System.out.print("Enter the book ID you want to borrow: ");
        int bookId = scanner.nextInt();

        Book bookToBorrow = library.findBookById(bookId);

        if (bookToBorrow != null && bookToBorrow.isAvailable()) {
            bookToBorrow.borrowBook();
            System.out.println("Book borrowed successfully by " + user.getUsername());
        } else {
            System.out.println("Book not available for borrowing or invalid book ID.");
        }
    }

    private static void returnBook(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        User user = new User(username, password);

        System.out.print("Enter the book ID you want to return: ");
        int bookId = scanner.nextInt();

        Book bookToReturn = library.findBookById(bookId);

        if (bookToReturn != null && !bookToReturn.isAvailable()) {
            bookToReturn.returnBook();
            System.out.println("Book returned successfully by " + user.getUsername());
        } else {
            System.out.println("Book is already available or invalid book ID.");
        }
    }
}
