/*
    * Ahmed Khaled Ahmed Fouad  - https://ahmedk.work/ - 63ahmedkhaled@gmail.com
    * CV - https://drive.google.com/file/d/1ka_UgJIGNAZjFVbOpRj9FuTcCV2QqBM1/view?usp=sharing
    * Fawry Rise Internship - Full Stack Submission (task 2)
    * https://github.com/a04k/fawrytask02
*/

import models.*;

public class App {
   public static void main(String[] args) {
       BookStore store = new BookStore();
       
       PaperBook paperBook = new PaperBook("BOOK1", "Atomic Habits", "James Clear", 2018, 200, 3);
       Ebook ebook = new Ebook("BOOK2", "The Hunger Games", "Suzanne Collins", 2008, 120, "EPUB");
       ShowcaseBook showcaseBook = new ShowcaseBook("BOOK3", "How to Build a Car", "Adrian Newey", 2017, 250); // great book if u r an f1/motorsport follower !
       PaperBook oldBook = new PaperBook("BOOK4", "The Art of War", "Sun Tzu", 1990, 80, 2); // old book for testing removal
       
       store.addBook(paperBook);
       store.addBook(ebook);
       store.addBook(showcaseBook);
       store.addBook(oldBook);
       
       store.showInventory();
       
       try {
           double amount1 = store.buyBook("BOOK1", 2, "reader1@email.com", "Cairo, Egypt");
           System.out.println("Total paid: " + amount1 + " EGP");
           
           double amount2 = store.buyBook("BOOK2", 1, "customer420@email.com", "Alexandria, Egypt");
           System.out.println("Total paid: " + amount2 + " EGP");
           
       } catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
       }
       
       // test buying a showcase book , gives an err
       try {
           store.buyBook("BOOK3", 1, "test888@email.com", "Giza, Egypt");
       } catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
       }
       
       // test buying more than available stock
       try {
           store.buyBook("BOOK1", 5, "greedyguy66@email.com", "Aswan, Egypt");
       } catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
       }

        // test buying buying book that doenst exist
       try {
           store.buyBook("BOOK33", 1, "delusional@email.com", "Cairo2, Egypt");
       } catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
       }
       
       // test removing old (pre-2000) books
       store.removeOutdatedBooks(25); 
       store.showInventory();
   }
}