package ejb;

import javax.ejb.Remote;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by levente on 2017.06.05..
 */
@Remote
public interface BookEJBRemote {

    List<Book> findBooks();
    @NotNull Book createBook(@NotNull Book book);
    void deleteBook(Book book);
    @NotNull Book updateBook(@NotNull Book book);
}
