package models;

public class PaperBook extends Book {
    private int stock;
    
    public PaperBook(String isbn, String title, String author, int publishedYear, double price, int stock) {
        super(isbn, title, author, publishedYear, price);
        this.stock = stock;
    }
    
    public int getStock() {
        return stock;
    }
    
    public void reduceStock(int quantity) {
        if (quantity > stock) {
            throw new RuntimeException("Insufficient stock for book: " + title);
        }
        stock -= quantity;
    }
    
    @Override
    public boolean canBuy() {
        return stock > 0;
    }
    
    @Override
    public void processPurchase(int quantity, String email, String address) {
        reduceStock(quantity);
        ShippingService.ship(this, address);
    }
    
    @Override
    public String getBookType() {
        return "Paper Book";
    }
}