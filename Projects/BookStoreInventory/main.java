package Projects.BookStoreInventory;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class main {
 
   static class Book{
        int ISBN;
        String title;
        String author;
        double price;
        String publicationDate;
   
        Book(int isbn, String t, String a, double p, String pd) {
            this.ISBN = isbn; 
            this.title = t; 
            this.author = a; 
            this.price = p; 
            this.publicationDate = pd;
        } 
    };

    // HashTable class
   static class HashTable {
        Map<Integer, Book> table = new HashMap<>();

        public void insert(int key, Book book){
            table.put(key, book);
        }

        public void remove(int key){
            table.remove(key);
        }

         public Book search(int key){
            return table.getOrDefault(key, null)
        }
             
    }


    // Balanced Binary Tree
    static class BookStoreTree {
        Map<Integer, Book> tree = new TreeMap<>(); // ISBN as the key

        public void insert(Book book){
            tree.put(book.ISBN, book);
        }

        public void remove(int key){
            tree.remove(key);
        }

        Book search(int key){
           return tree.getOrDefault(key, null);
        }

        public void displayByPrice() {
           tree.values().stream().sorted(Comparator.comparingDouble(book -> book.price)).forEach(book -> System.out.println("ISBN: " + book.ISBN + ", Title: " + book.title + ", Price: " + book.price));
        }

        public void displayByDate() {
            // Sorting by Date will require a different structure or custom comparator
            // Here we are just displaying by order of insertion (which is by ISBN in this case)
              tree.values().stream().sorted(Comparator.comparing(book -> book.publicationDate)).forEach(book -> System.out.println("ISBN: " + book.ISBN + ", TItle: " + book.title + ", Price: " + book.price));
             };
    }
}
