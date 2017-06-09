import ejb.Book;
import ejb.BookEJBRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;

/**
 * Created by levente on 2017.06.05..
 */
public class Main {

    public static void main(String[] args) throws NamingException {

        Context ctx = new InitialContext();
        BookEJBRemote bookEJB = (BookEJBRemote) ctx.lookup("java:module/ejb.BookEJB!src.main.java.ejb.BookEJBRemote");

        // Gets and displays all the books from the database
        List<Book> books = bookEJB.findBooks();
        for (Book aBook : books) {
            System.out.println("--- " + aBook);
        }

        Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction by Douglas Adams.", "1-24561-799-0", 354, false);

        book = bookEJB.createBook(book);
        System.out.println("### ejb.Book created : " + book);

        book.setTitle("H2G2");
        book = bookEJB.updateBook(book);
        System.out.println("### ejb.Book updated : " + book);

        bookEJB.deleteBook(book);
        System.out.println("### ejb.Book deleted");
    }
}
