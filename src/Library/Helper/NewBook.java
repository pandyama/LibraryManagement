package Library.Helper;

import Library.Objects.Book;
import Library.DatabaseHelper.BookDaoImpl;

import java.util.Scanner;

public class NewBook {

    public String getNewBookDetails(int num){

        BookDaoImpl b1 = new BookDaoImpl();
        Scanner myObj = new Scanner(System.in);

        String bookT;
        String bookA;
        String bookG;
        String bookP;
        int py;
        int number;
        String borrowed;

        Book nb;

        for(int i = 0; i < num; i++){
            System.out.println("Title: ");
            bookT = myObj.nextLine();  // Read user input
            System.out.println("Author: ");
            bookA = myObj.nextLine();
            System.out.println("Genre: ");
            bookG = myObj.nextLine();
            System.out.println("Publisher: ");
            bookP = myObj.nextLine();
            System.out.println("year: ");
            py = myObj.nextInt();
            System.out.println("num: ");
            number = myObj.nextInt();
            System.out.println("borrowed: ");
            borrowed = myObj.nextLine();

            nb = new Book(bookT, bookA, bookG, bookP, py, number);
            b1.addBook(nb);
        }

        return "Successfully Added new book";
    }
}
