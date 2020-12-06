package views;

import controllers.BookController;
import dtos.BookWithAuthorName;

import java.util.List;
import java.util.Scanner;

public class ViewMain {
    Scanner sc = new Scanner(System.in);

    public ViewMain() {
        while (true) {
            System.out.println("1.Show all books");
            System.out.println("2.Add book");
            System.out.println("3.Update book");
            System.out.println("4.Delete book");
            int input = sc.nextInt();
            if (input == 1) {
                // show all books
                List<BookWithAuthorName> response = BookController.getInstance().getAllBooks();
                for (int i = 0; i < response.size(); i++) {
                    System.out.println(response.get(i));
                }
            }
        }
    }
}
