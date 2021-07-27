package Library.DatabaseHelper;

import Library.DAO.PersonDao;
import Library.Objects.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PersonaDaoImpl implements PersonDao {
    @Override
    public void addPerson(Person p1) {
        try{
            Connection c1 = DriverManager.getConnection("jdbc:mariadb://localhost:3306/Library?user=root&password=mproot");
            String createPerson = "CREATE TABLE IF NOT EXISTS Person(" +
                    "personID INT NOT NULL AUTO_INCREMENT," +
                    "firstName VARCHAR(30) NOT NULL," +
                    "lastName VARCHAR(30) NOT NULL," +
                    "loginID VARCHAR(30) NOT NULL," +
                    "password VARCHAR(30) NOT NULL," +
                    "phone VARCHAR(12) NOT NULL," +
                    "address VARCHAR(40) NOT NULL," +
                    "type INT NOT NULL," +
                    "PRIMARY KEY(personID));";

            PreparedStatement preparedStmt = c1.prepareStatement(createPerson);
            preparedStmt.execute();

            String query = "INSERT Person VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStmt2 = c1.prepareStatement(query);
            preparedStmt2.setInt(1,0);
            preparedStmt2.setString(2, p1.getFirstName());
            preparedStmt2.setString(3, p1.getLastName());
            preparedStmt2.setString(4, p1.getLogin());
            preparedStmt2.setString(5, p1.getPassword());
            preparedStmt2.setString(6, p1.getPhone());
            preparedStmt2.setString(7, p1.getAddress());
            preparedStmt2.setInt(8,p1.getType());
            preparedStmt2.execute();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
