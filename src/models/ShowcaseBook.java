package models;

public class ShowcaseBook extends Book {
    
    public ShowcaseBook(String isbn, String title, String author, int publishedYear, double price) {
        super(isbn, title, author, publishedYear, price);
    }
    
    @Override
    public boolean canBuy() {
        return false;
    }
    
    @Override
    public void processPurchase(int quantity, String email, String address) {
        throw new RuntimeException("Showcase book not for sale: " + title);
    }
    
    @Override
    public String getBookType() {
        return "Showcase Book";
    }
}