package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookStore {
    private Map<String, Book> inventory;
    
    public BookStore() {
        this.inventory = new HashMap<>();
    }
    
    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
        System.out.println("Added >>> " + book.getBookType() + " - " + book.getTitle() + " by " + book.getAuthor());
    }
    
    public List<Book> removeOutdatedBooks(int maxAge) {
        List<Book> removedBooks = new ArrayList<>();
        int currentYear = java.time.Year.now().getValue();
        
        for (String isbn : new ArrayList<>(inventory.keySet())) {
            Book book = inventory.get(isbn);
            if (currentYear - book.getPublishedYear() > maxAge) {
                removedBooks.add(book);
                inventory.remove(isbn);
                System.out.println("removed outdated book -> " + book.getTitle());
            }
        }
        
        return removedBooks;
    }
    
    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.get(isbn);
        
        if (book == null) {
            throw new RuntimeException("Book not found: " + isbn);
            // book has so name bc it doesnt exist so the isbn is used (which also doesnt exist)
        }
        
        if (!book.canBuy()) {
            throw new RuntimeException("book not available:" + book.getTitle());
        }
        
        book.processPurchase(quantity, email, address);
        
        double totalAmount = book.getPrice() * quantity;
        System.out.println("Purchased succesfully! :: " + book.getTitle() + " x" + quantity + " = LE/EGP" + totalAmount);
        
        return totalAmount;
    }
    
    public Book getBook(String isbn) {
        return inventory.get(isbn);
    }
    
    public void showInventory() {
        System.out.println("Current Inventory: ");
        for (Book book : inventory.values()) {
            System.out.println("->" + book.getTitle() + " by " + book.getAuthor() + " (" + book.getBookType() + ")");
        }
    }
}
