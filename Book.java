 
public class Book {
 
    String name;
    String author;
    long id;
    float price;
   
 
    public Book(String name, String author, long id, float price) {
        this.name = name;
        this.author = author;
        this.id = id;
        this.price = price;
    }
 
 public String toString() {
        return name + "\t" + author + "\t" + id + "\t" + ": Rs" + price;
  }
 
}
