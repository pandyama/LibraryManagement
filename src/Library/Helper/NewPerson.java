package Library.Helper;

import Library.DatabaseHelper.PersonDaoImpl;
import Library.Objects.Person;

import java.util.Scanner;

public class NewPerson {

    public String getNewPersonDetails(int num){
        PersonDaoImpl p1 = new PersonDaoImpl();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String fn,ln,pw,ph,addr;
        int ptype;
        Person newp;

        for(int i = 0; i < num; i++){
            System.out.println("First Name: ");
            fn = myObj.nextLine();  // Read user input
            System.out.println("Last Name: ");
            ln = myObj.nextLine();
            System.out.println("Password: ");
            pw = myObj.nextLine();
            System.out.println("Phone: ");
            ph = myObj.nextLine();
            System.out.println("Address: ");
            addr = myObj.nextLine();
            System.out.println("Person Type (Member or Librarian): ");
            ptype = myObj.nextInt();

            newp = new Person(fn,ln,pw,ph,addr,ptype);
            p1.addPerson(newp);
        }
        return "Successfully Added new persons";
    }
}
