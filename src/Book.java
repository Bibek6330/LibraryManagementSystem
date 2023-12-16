public class Book {
    private int bookId;
    private String title;
    private boolean available;

    public Book(int bookId, String title) {
        this.bookId = bookId;
        this.title = title;
        this.available = true;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is not available for borrowing.");
        }
    }

    public void returnBook() {
        available = true;
        System.out.println("Book returned successfully.");
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Available: " + available;
    }
}
