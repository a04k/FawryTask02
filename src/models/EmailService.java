package models;

public class EmailService {
    public static void sendEmail(Ebook book, String email) {
        System.out.println("Sent - " + book.getTitle() + " (" + book.getFileType() + ") to " + email);
    }
}