package Library;

import Library.Helper.NewBook;
import Library.Helper.NewPerson;
import Library.DatabaseHelper.BookDaoImpl;
import java.util.Scanner;

public class entry {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("LIBRARY MANAGEMENT SYSTEM");
        System.out.println("Please Select an Option");
        System.out.println("-------------------------");
        System.out.println("1 - Add a new Person");
        System.out.println("2 - Add a new Book");
        System.out.println("3 - Borrow a Book");
        int selected = myObj.nextInt();

        if(selected == 1){
            NewPerson n1 = new NewPerson();
            n1.getNewPersonDetails(1);
        }
        else if(selected == 2){
            NewBook b1 = new NewBook();
            b1.getNewBookDetails(1);
        }
        else{
            BookDaoImpl b2 = new BookDaoImpl();
            b2.getBooks();

        }
    }
}
