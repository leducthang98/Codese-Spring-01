package entities;

public class Book {
    public int id;
    public String name;
    public int authorId;

    public Book(int id, String name, int authorId) {
        this.id = id;
        this.name = name;
        this.authorId = authorId;
    }

    public Book() {
    }
}
