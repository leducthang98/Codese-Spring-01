package services;

import dtos.BookWithAuthorName;
import repositories.BookRepository;

import java.util.List;

public class BookService {
    BookRepository bookRepository = new BookRepository();

    public List<BookWithAuthorName> getAllBooks() {
        // xu ly nghiep vu
        // call repository
        try {
            return bookRepository.getAllBooks();
        } catch (Exception e) {
            return null;
        }
    }

//    public boolean deleteBook(int bookId) {
//        // goi toi 1 ham gi do => check xem book co ton tai khong
//        boolean isBookExist = true;
//        if(isBookExist){
//            // call repository
//        }else{
////            return;
//        }
//    }

}
