package Library.Objects;

public class Book {
    private int bookID = -1;
    private String title;
    private String genre;
    private String author;
    private String publisher;
    private int publishedYear;
    private int numOfPages;
    private boolean checkedOut;

    public Book(String bTitle, String bAuthor, String bGenre, String publisher, int publishedYear, int numOfPages){
        if(bookID == -1){
            bookID = 1;
        }
        else{
            bookID++;
        }
        this.title = bTitle;
        this.genre = bGenre;
        this.author = bAuthor;
        this.publisher = publisher;
        this.publishedYear = publishedYear;
        this.numOfPages = numOfPages;
    }

    public String getBookTitle(){
        return title;
    }

    public String getBookGenre(){
        return genre;
    }

    public String getBookAuthor(){
        return author;
    }

    public String getPublisher() { return publisher; }

    public int getPublishedYear() { return publishedYear; }

    public int getNumOfPages() { return numOfPages; }

    public int getBookID(){ return bookID; }
}
