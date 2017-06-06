import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by levente on 2017.06.05..
 */
@Stateless
@LocalBean
public class BookEJB implements BookEJBRemote {

    @Inject
    EntityManager em;

    public List<Book> findBooks() {
        TypedQuery<Book> query = em.createNamedQuery("allbooks", Book.class);
        return query.getResultList();
    }

    public @NotNull Book createBook(@NotNull Book book) {
        em.persist(book);
        return book;
    }

    public void deleteBook(@NotNull Book book) {
        em.remove(em.merge(book));
    }

    public @NotNull Book updateBook(@NotNull Book book) {
        return em.merge(book);
    }
}
