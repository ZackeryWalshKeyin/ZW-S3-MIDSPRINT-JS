package library;

public interface Borrowable {
    boolean borrow(int  numberOfCopies);
    boolean returnBook(int numberOfCopies);
}

