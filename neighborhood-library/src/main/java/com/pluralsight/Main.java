package com.pluralsight;

import java.util.Scanner;

public class Main {
    // Scanner object for user input
    static Scanner scanner = new Scanner(System.in);
    
    // Array to store all books in the library
    static Book[] books = new Book[20];

    // Main method - program entry point
    public static void main(String[] args) {
        // Initialize library with 20 books
        initializeBooks();

        // Create instance of Main and start the program
        Main main = new Main();
        main.screen();
    }

    // Method to initialize books
    private static void initializeBooks() {
        books[0] = new Book(1, "1234", "Book 1");
        books[1] = new Book(2, "5678", "The Midnight Garden");
        books[2] = new Book(3, "9012", "Echoes of Eternity");
        books[3] = new Book(4, "3456", "Quantum Horizon");
        books[4] = new Book(5, "7890", "Whispers in the Wind");
        books[5] = new Book(6, "2345", "The Forgotten Realm");
        books[6] = new Book(7, "6789", "Crimson Skies");
        books[7] = new Book(8, "0123", "Silent Echoes");
        books[8] = new Book(9, "4567", "Eternal Shadows");
        books[9] = new Book(10, "8901", "The Lost Chronicle");
        books[10] = new Book(11, "2468", "Mystic Passages");
        books[11] = new Book(12, "1357", "Starlight Odyssey");
        books[12] = new Book(13, "9876", "The Hidden Path");
        books[13] = new Book(14, "5432", "Infinite Horizons");
        books[14] = new Book(15, "0246", "Whispers of Time");
        books[15] = new Book(16, "8642", "The Forgotten City");
        books[16] = new Book(17, "1122", "Lunar Legends");
        books[17] = new Book(18, "3344", "Cosmic Secrets");
        books[18] = new Book(19, "5566", "The Ethereal Journey");
        books[19] = new Book(20, "7788", "Shadows of Destiny");
    }

    // Display and handle main menu options
    public void screen() {
        boolean isRunning = true;

        while (isRunning) {
            // Display main menu options
            System.out.println("\nWelcome to the Neighborhood Library");
            System.out.println("Please select an option:");
            System.out.println("1: Show Available Books");
            System.out.println("2: Show Checked Out Books");
            System.out.println("3: Exit");

            try {
                // Get user's menu choice
                System.out.println("--------User Input--------");
                System.out.print("Option Entered is: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Clear input buffer
                System.out.println("-------------------------");

                // Process user's choice
                switch (option) {
                    case 1:
                        showAvailableBooks();
                        break;
                    case 2:
                        showCheckedOutBooks();
                        break;
                    case 3:
                        System.out.println("Now Exiting the Library");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid Option");
                }
            } catch (Exception e) {
                System.out.println("Invalid Option");
                scanner.next(); // Clear invalid input
            }
        }
    }

    // Display available books and handle checkout process
    public void showAvailableBooks() {
        boolean foundBooks = false;

        // Loop through all books to find available ones
        for (Book book : books) {
            if (book != null && !book.isCheckedOut()) {
                System.out.printf("Book is available: Id| %d | ISBN| %s | Title| %s\n",
                        book.getId(), book.getIsbn(), book.getTitle());
                foundBooks = true;
            }
        }

        // If no books available, return to main menu
        if (!foundBooks) {
            System.out.println("No books available");
            return;
        }

        // Prompt for checkout
        System.out.println("Do you want to check out a book?");
        System.out.println("1: Check Out a Book");
        System.out.println("Any other key: Return to Main Menu");

        try {
            System.out.println("--------User Input--------");
            System.out.print("Option Entered is: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear input buffer
            System.out.println("-------------------------");

            if (choice == 1) {
                processCheckout();
            }
        } catch (Exception e) {
            System.out.println("Returning to main menu");
        }
    }

    // Process book checkout
    private void processCheckout() {
        System.out.println("Please enter the book id to check out");
        
        try {
            int id = scanner.nextInt();
            scanner.nextLine(); // Clear input buffer

            // Search for requested book
            for (Book book : books) {
                if (book != null && book.getId() == id && !book.isCheckedOut()) {
                    System.out.println("Please enter your name ");
                    String name = scanner.nextLine();
                    book.checkOut(name); // Mark book as checked out
                    System.out.println("Book checked out successfully");
                    return;
                }
            }
            System.out.println("Book not available");
        } catch (Exception e) {
            System.out.println("Invalid input");
            scanner.nextLine(); // Clear input buffer
        }
    }

    // Show all checked out books and handle check-in options
    public void showCheckedOutBooks() {
        boolean hasCheckedOutBooks = false;

        // Display all checked out books
        for (Book book : books) {
            if (book != null && book.isCheckedOut()) {
                System.out.printf("ID| %d | ISBN| %s | Title| %s | Checked Out To| %s\n", 
                    book.getId(), book.getIsbn(), book.getTitle(), book.getCheckedOutTo());
                hasCheckedOutBooks = true;
            }
        }

        // If no books are checked out, return to main menu
        if (!hasCheckedOutBooks) {
            System.out.println("No books are currently checked out");
            return;
        }

        // Show check-in options
        System.out.println("-------Please select an option:---------");
        System.out.println("C. Check In Book");
        System.out.println("X. Return to Main Menu");

        // Get user's choice
        System.out.println("--------User Input--------");
        System.out.print("Option Entered is: ");
        String option = scanner.nextLine();
        System.out.println("-------------------------");

        // Process user's choice
        if (option.equalsIgnoreCase("C")) {
            checkInBook();
        }
    }

    // Handle book check-in process
    public void checkInBook() {
        System.out.println("Please enter the book id to check in");
        
        try {
            // Get book ID from user
            int id = scanner.nextInt();
            scanner.nextLine();

            // Search for book to check in
            for (Book book : books) {
                if (book != null && book.getId() == id && book.isCheckedOut()) {
                    book.checkIn(); // Use Book class method to check in
                    System.out.println("Book checked in successfully");
                    return;
                }
            }
            System.out.println("Book not found or not checked out");
        } catch (Exception e) {
            System.out.println("Invalid input");
            scanner.nextLine(); // Clear input buffer
        }
    }
}