## Update 2: Screenshots of the app running

### note: task was completed with the previous commit, no code was updated past the given deadline 

### Full App.java run screenshot:

![{8D20B5B7-E5D9-4420-9695-EF8CDC442D43}](https://github.com/user-attachments/assets/e5e856b7-d0ac-4be4-85f1-4263062cd959)

### This is the [App.java](https://github.com/a04k/FawryTask02/blob/master/src/App.java) code ran in the screenshot above 

```java
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
```



## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
