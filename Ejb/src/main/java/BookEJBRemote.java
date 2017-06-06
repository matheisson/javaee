import java.util.List;

/**
 * Created by levente on 2017.06.05..
 */
public interface BookEJBRemote {

    List<Book> findBooks();
    Book createBook(Book book);
    void deleteBook(Book book);
    Book updateBook(Book book);
}
