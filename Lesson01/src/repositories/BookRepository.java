package repositories;

import dtos.BookWithAuthorName;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    public List<BookWithAuthorName> getAllBooks() {
        // query JDBC Driver
        // fake du lieu
        //query...
        //tra ve du lieu
        List<BookWithAuthorName> listBooks = new ArrayList<>();
        BookWithAuthorName book1 = new BookWithAuthorName();
        book1.id = 0;
        book1.name = "sach1";
        book1.authorId = 1;
        book1.authorName = "Thang";

        BookWithAuthorName book2 = new BookWithAuthorName();
        book2.id = 1;
        book2.name = "sach2";
        book2.authorId = 2;
        book2.authorName = "Thien";

        listBooks.add(book1);
        listBooks.add(book2);

        return listBooks;
    }
}
