package library;

import library.enums.Status;

public class Book implements Borrowable{
    private String title;
    private Author author;
    private String ISBN;
    @SuppressWarnings("unused")
    private String publisher;
    private int numberOfCopies;
    private Status status;

    public Book(String title, Author author, String ISBN, String publisher, int numberOfCopies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
        this.status = Status.AVAILABLE;
    }

    // Implementing methods from Borrowable interface
    //@Override
    public boolean borrow(int numberOfCopies) {
        if (this.numberOfCopies >= numberOfCopies) {
            this.numberOfCopies -= numberOfCopies;
            this.status = Status.CHECKED_OUT;
            return true;
        } else {
            return false;
        }
    }

    //@Override
    public boolean returnBook(int numberOfCopies) {
        this.numberOfCopies += numberOfCopies;
        this.status = Status.AVAILABLE;
        return true;
    }



   // Setters
   public void setTitle(String title) {
    this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }
    
    public Author getAuthor() {
        return author;
    }
    
    public String getISBN() {
        return ISBN;
    }

    public Status getStatus() {
        return status;
    }

    private Patron borrower;

    public Patron getBorrower() {
        return borrower;
    }

    public void setBorrower(Patron borrower) {
        this.borrower = borrower;
    }

}
