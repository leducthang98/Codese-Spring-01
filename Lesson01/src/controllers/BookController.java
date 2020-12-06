package controllers;

import dtos.BookWithAuthorName;
import entities.Book;
import services.BookService;

import java.util.List;

public class BookController {
    private static BookController instance;

    BookService bookService = new BookService();

    public static BookController getInstance() {
        if (instance == null) {
            instance = new BookController();
        }
        return instance;
    }

    private BookController() {
    }

    public List<BookWithAuthorName> getAllBooks() {
        // goi toi service
        return bookService.getAllBooks();
    }

//    public boolean deleteBook(int bookId) {
//        return bookService.deleteBook(bookId);
//    }
}
