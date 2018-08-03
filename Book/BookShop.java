import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.lang.Iterable;
 
public class BookShop implements Iterable<Book> {
 
    List<Book> avail_books;
 
    public BookShop() {
        avail_books = new ArrayList<Book>();
    }
 
    public void addBook(Book book) {
        avail_books.add(book);
    }
    @Override
    public Iterator<Book> iterator() {
        return (Iterator<Book>)new BookShopIterator();
    }
 
    class BookShopIterator implements Iterator<Book> {
        int currentIndex = 0;
 
        @Override
        public boolean hasNext() {
            if (currentIndex >= avail_books.size()) {
                return false;
            } else {
                return true;
            }
        }
 
        @Override
        public Book next() {
            if(avail_books.get(currentIndex).name.equals("Spring"))
               { currentIndex++;
                return avail_books.get(currentIndex-1);
                }
            else
            {currentIndex++;
            return null;}
            // if(!avail_books.isEmpty())
            // return avail_books.get(currentIndex++);
            // else{
            // System.exit(0);
            // return null;}
        }
        public void removeAll() {
            if(!avail_books.isEmpty())
            {avail_books.removeAll(avail_books);
            currentIndex=0;}
            
        }
 
    }
    
    
    
  public static void main(String[] args) {
 
        Book book1 = new Book("Java", "JamesGosling", 123456, 1000.0f);
        Book book2 = new Book("Spring", "RodJohnson", 789123, 1500.0f);
        Book book3 = new Book("Struts", "Apache", 456789, 800.0f);
        Book book4 = new Book("Java", "JamesGosling", 123456, 1000.0f);
        Book book5 = new Book("Spring", "RodJohnson", 789123, 1500.0f);
        Book book6 = new Book("Struts", "Apache", 456789, 800.0f);
 
        BookShop avail_books = new BookShop();
        avail_books.addBook(book1);
        avail_books.addBook(book2);
        avail_books.addBook(book3);
        avail_books.addBook(book4);
        avail_books.addBook(book5);
        avail_books.addBook(book6);
        BookShopIterator bs=(BookShopIterator) avail_books.iterator();
        System.out.println("Displaying Books:");
        for(Book total_books : avail_books){
            System.out.println(total_books);
           // bs.remove();
        }
        System.out.println("Removing books");
        bs.removeAll();
        if(bs.hasNext()){
            
        for(Book total_books : avail_books){
            System.out.println(total_books);
           // bs.remove();
        }System.out.println("inside if"+bs.hasNext());
        System.out.print(bs.next());
        }
    }
 
}
