package models;

public abstract class Book {
    protected String isbn;
    protected String title;
    protected String author;
    protected int publishedYear;
    protected double price;
    
    public Book(String isbn, String title, String author, int publishedYear, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.price = price;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getPublishedYear() {
        return publishedYear;
    }
    
    public double getPrice() {
        return price;
    }
    
    public abstract boolean canBuy();
    public abstract void processPurchase(int quantity, String email, String address);
    public abstract String getBookType();
}