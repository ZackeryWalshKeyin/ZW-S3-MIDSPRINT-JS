package library;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String authorName;
    private String dateOfBirth;
    private List<Book> booksWritten;

    public Author(String authorName, String dateOfBirth) {
        this.authorName = authorName;
        this.dateOfBirth = dateOfBirth;
        this.booksWritten = new ArrayList<>();
    }


    // Getters
    public String getauthorName() {
        return authorName;
    }
    
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
    public List<Book> getBooksWritten() {
        return booksWritten;
    }
    
    // Setters
    public void setauthorName(String authorName) {
        this.authorName = authorName;
    }
    
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public void setBooksWritten(List<Book> booksWritten) {
        this.booksWritten = booksWritten;
    }
    
    // Other methods...
    // Method to add a book written by the author
    public void addBookWritten(Book book) {
        booksWritten.add(book);
    }

    // Method to remove a book written by the author
    public void removeBookWritten(Book book) {
        booksWritten.remove(book);
    }


    public class AuthorManager {
        private List<Author> authors;
    
        public AuthorManager() {
            this.authors = new ArrayList<>();
        }
    
        // Method to add an author to the list
        public void add(Author author) {
            authors.add(author);
        }
}
}