package com.pluralsight;

// Book class to represent a library book and its properties
public class Book {
    // Private fields to store book information
    private int id; // Stores unique book identifier
    private String isbn; // Stores ISBN (International Standard Book Number)
    private String title; // Stores book title
    private boolean isCheckedOut;// Tracks checkout status (true = checked out, false = available)
    private String checkedOutTo; // Stores name of person who has book checked out

    // Constructor: Creates new book with initial values
    public Book(int id, String isbn, String title) {
        this.id = id; // Set book ID
        this.isbn = isbn; // Set ISBN
        this.title = title; // Set title
        this.isCheckedOut = false; // Initially not checked out
        this.checkedOutTo = ""; // Initially not checked out to anyone
    }

    // Getter method: Returns book ID
    public int getId() {
        return id;
    }

    // Setter method: Sets book ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter method: Returns ISBN
    public String getIsbn() {
        return isbn;
    }

    // Setter method: Sets ISBN
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Getter method: Returns title
    public String getTitle() {
        return title;
    }

    // Setter method: Sets title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter method: Returns checkout status
    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    // Setter method: Sets checkout status
    public void setCheckedOut(boolean isCheckedOut) {
        this.isCheckedOut = isCheckedOut;
    }

    // Getter method: Returns name of person who has book
    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    // Setter method: Sets name of person checking out book
    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    // Method to handle checking out a book
    public void checkOut(String name) {
        this.isCheckedOut = true; // Mark as checked out
        this.checkedOutTo = name; // Store borrower's name
    }

    // Method to handle checking in a book
    public void checkIn() {
        this.isCheckedOut = false; // Mark as available
        this.checkedOutTo = ""; // Clear borrower's name
    }

    // Override toString method to provide book information
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id + // Include ID in output
                ", isbn='" + isbn + '\'' + // Include ISBN in output
                ", title='" + title + '\'' + // Include title in output
                '}';
    }
}
