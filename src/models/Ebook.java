package models;

public class Ebook extends Book {
    private String fileType;
    
    public Ebook(String isbn, String title, String author, int publishedYear, double price, String fileType) {
        super(isbn, title, author, publishedYear, price);
        this.fileType = fileType;
    }
    
    public String getFileType() {
        return fileType;
    }
    
    @Override
    public boolean canBuy() {
        return true;
    }
    
    @Override
    public void processPurchase(int quantity, String email, String address) {
        EmailService.sendEmail(this, email);
    }
    
    @Override
    public String getBookType() {
        return "eBook";
    }
}