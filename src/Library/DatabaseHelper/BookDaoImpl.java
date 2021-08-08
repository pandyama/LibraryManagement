package Library.DatabaseHelper;

import Library.Constants;
import Library.Objects.Book;
import Library.DAO.BookDao;
import java.sql.*;

public class BookDaoImpl implements BookDao {
    Constants c = new Constants();

    @Override
    public void addBook(Book b1) {
        try{
            Connection c1 = DriverManager.getConnection("jdbc:mariadb://localhost:3306/Library?user=root&password="+c.maria);
            String createBookTable = "CREATE TABLE IF NOT EXISTS Book(" +
                    "bookID INT NOT NULL AUTO_INCREMENT,\n" +
                    "bookTitle VARCHAR(30) NOT NULL,\n" +
                    "bookAuthor VARCHAR(20) NOT NULL,\n" +
                    "bookGenre VARCHAR(20) NOT NULL,\n" +
                    "bookPublisher VARCHAR(20) NOT NULL,\n" +
                    "publishYear INT NOT NULL,\n" +
                    "numOfPages INT NOT NULL,\n" +
                    "borrowed BOOLEAN,\n" +
                    "PRIMARY KEY(bookID));";

            PreparedStatement preparedStmt = c1.prepareStatement(createBookTable);
            preparedStmt.execute();

            String query = "INSERT Book VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStmt2 = c1.prepareStatement(query);
            preparedStmt2.setInt(1,0);
            preparedStmt2.setString(2, b1.getBookTitle());
            preparedStmt2.setString(3, b1.getBookAuthor());
            preparedStmt2.setString(4, b1.getBookGenre());
            preparedStmt2.setString(5, b1.getPublisher());
            preparedStmt2.setInt(6, b1.getPublishedYear());
            preparedStmt2.setInt(7, b1.getNumOfPages());
            preparedStmt2.setBoolean(8,false);
            preparedStmt2.execute();

        }
        catch(Exception e){

        }
    }

    @Override
    public void getBooks() {
        try{

            Connection c1 = DriverManager.getConnection("jdbc:mariadb://localhost:3306/Library?user=root&password="+c.maria);
            String getBooks = "SELECT * From Book;";
            Statement s1 = c1.createStatement();
            ResultSet rs;
            rs = s1.executeQuery(getBooks);
            while(rs.next()){
                System.out.print(rs.getInt("bookID")+" - ");
                System.out.print(rs.getString("bookTitle")+" - ");
                System.out.print(rs.getString("bookAuthor")+" - ");
                System.out.print(rs.getString("bookGenre")+" ");
                System.out.println("");
            }

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void borrowBook(int id){
        try{
            Connection c1 = DriverManager.getConnection("jdbc:mariadb://localhost:3306/Library?user=root&password="+c.maria);
            String borrowBook = "UPDATE Book SET borrowed=1 WHERE bookID = "+id+";";
            PreparedStatement preparedStmt2 = c1.prepareStatement(borrowBook);
            preparedStmt2.execute();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
