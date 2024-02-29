package library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import library.enums.Status; 

public class Library {
    private List<Book> books;
    private List<Author> authors;
    private List<Patron> patrons;

    public Library() {
        this.books = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    // Methods for managing books
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to delete a book from the library
    public void deleteBook(Book book) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book currentBook = iterator.next();
            if (currentBook.equals(book)) {
                iterator.remove();
                break;
            }
        }
    }
    
    public boolean borrowBook(Book book, Patron patron, int i) {
        if (books.contains(book) && patrons.contains(patron)) {
            if (book.getStatus() == Status.AVAILABLE) {
                book.setStatus(Status.CHECKED_OUT);
                // Add the book to the list of borrowed books for the patron
                patron.borrowBook(book);
                System.out.println("Book borrowed successfully!");
            } else {
                System.out.println("Book is currently not available for borrowing.");
            }
        } else {
            System.out.println("Book or patron not found in the library.");
        }
        return false;
    }

    public void returnBook(Book book, Patron patron, int i) {
        if (books.contains(book) && patrons.contains(patron)) {
            if (patron.hasBorrowedBook(book)) {
                book.setStatus(Status.AVAILABLE);
                // Remove the book from the list of borrowed books for the patron
                patron.returnBook(book);
                System.out.println("Book returned successfully!");
            } else {
                System.out.println("Patron hasn't borrowed this book.");
            }
        } else {
            System.out.println("Book or patron not found in the library.");
        }
    }

    public List<Book> searchBooksByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchBooksByAuthor(String authorName) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().getauthorName().equalsIgnoreCase(authorName)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchBooksByISBN(String ISBN) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getISBN().equalsIgnoreCase(ISBN)) {
                result.add(book);
            }
        }
        return result;
    }

    // Methods for managing patrons
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public Patron searchPatronByName(String patronName) {
        for (Patron patron : patrons) {
            if (patron.getName().equalsIgnoreCase(patronName)) {
                return patron; // Found the patron with the provided name
            }
        }
        return null; // Patron not found
    }

    public void updateBook(Book bookToEdit) {
    // Iterate through the list of books in the library
    for (int i = 0; i < books.size(); i++) {
        Book book = books.get(i);
        // Check if the book in the library matches the updated book
        if (book.equals(bookToEdit)) {
            // Update the book with the new information
            books.set(i, bookToEdit);
            return;
        }
    }
    // If the book is not found in the library, print an error message
    System.out.println("Book not found in the library.");
    }

    public boolean editAuthor(String authorName, String newDateOfBirth) {
        for (Author author : authors) {
            if (author.getauthorName().equals(authorName)) {
                author.setDateOfBirth(newDateOfBirth);
                return true;
            }
        }
        return false;
    }

    public boolean addAuthor(String authorName, String dateOfBirth) {
        // Check if the author already exists
        for (Author author : authors) {
            if (author.getauthorName().equals(authorName)) {
                return false;
            }
        }
        
        // If the author doesn't exist, add them to the list
        authors.add(new Author(authorName, dateOfBirth));
        return true;
    }

    public boolean deleteAuthor(String authorName) {
        // Iterate over the list of authors
        for (Author author : authors) {
            // If the author's name matches, remove them from the list
            if (author.getauthorName().equals(authorName)) {
                authors.remove(author);
                return true;
            }
        }
        // If the author was not found, return false
        return false;
    }

    // Method to edit an existing patron's information
    public void editPatron(Patron oldPatron, Patron newPatron) {
        int index = patrons.indexOf(oldPatron);
        if (index != -1) {
            patrons.set(index, newPatron);
        }
    }

    // Method to delete an existing patron from the library
    public void deletePatron(Patron patron) {
        patrons.remove(patron);
    }

    // Method to search for books borrowed by a patron
    public List<Book> searchBooksByPatron(Patron patron) {
        List<Book> borrowedBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getStatus() == Status.CHECKED_OUT && book.getBorrower() == patron) {
                borrowedBooks.add(book);
            }
        }
        return borrowedBooks;
    }
}

