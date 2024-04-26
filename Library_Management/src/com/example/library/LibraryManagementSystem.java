package com.example.library;
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean available;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + ", Available: " + available;
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found:");
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void checkoutBook(int id) {
        for (Book book : books) {
            if (book.getId() == id && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("Book checked out successfully. ");
                return;
            }
        }
        System.out.println("Book not available for checkout. ");
    }

    public void returnBook(int id) {
        for (Book book : books) {
            if (book.getId() == id && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Invalid book ID or book already available.");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding some sample books
        library.addBook(new Book(1, "Java Programming", "John Smith"));
        library.addBook(new Book(2, "Python Basics", "Alice Johnson"));
        library.addBook(new Book(3, "Web Development", "David Brown"));
        library.addBook(new Book(4, "Data Structures and Algorithms", "Mark Jones"));
        library.addBook(new Book(5, "Machine Learning Essentials", "Emily White"));
        library.addBook(new Book(6, "Blockchain Revolution", "Michael Smith"));
        library.addBook(new Book(7, "Artificial Intelligence: A Modern Approach", "Stuart Russell"));
        library.addBook(new Book(8, "Cloud Computing Fundamentals", "Jessica Green"));
        library.addBook(new Book(9, "Mobile App Development with Flutter", "Kevin Lee"));
        library.addBook(new Book(10, "Cybersecurity: Principles and Practices", "Jennifer Brown"));
        library.addBook(new Book(11, "Introduction to Quantum Computing", "Daniel Taylor"));
        library.addBook(new Book(12, "Big Data Analytics", "Sophia Clark"));
        library.addBook(new Book(13, "Internet of Things (IoT) Handbook", "Andrew Miller"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display all books");
            System.out.println("2. Search for a book");
            System.out.println("3. Checkout a book");
            System.out.println("4. Return a book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nAll Books:");
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("\nEnter book title to search: ");
                    scanner.nextLine(); // Consume newline
                    String searchTitle = scanner.nextLine();
                    library.searchBook(searchTitle);
                    break;
                case 3:
                    System.out.print("\nEnter ID of book to checkout: ");
                    int checkoutId = scanner.nextInt();
                    library.checkoutBook(checkoutId);
                    break;
                case 4:
                    System.out.print("\nEnter ID of book to return: ");
                    int returnId = scanner.nextInt();
                    library.returnBook(returnId);
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
