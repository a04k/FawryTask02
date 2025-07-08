package models;

public class ShippingService {
    public static void ship(PaperBook book, String address) {
        System.out.println("Shipped" + book.getTitle() + " to " + address);
    }
}