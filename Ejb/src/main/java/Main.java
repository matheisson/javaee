import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by levente on 2017.06.05..
 */
public class Main {

    public static void main(String[] args) throws NamingException {

        Map<String, Object> properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));
        try (EJBContainer ec = EJBContainer.createEJBContainer(properties)) {
            Context ctx = ec.getContext();
            Book book = new Book();
            book.setTitle("The Hitchhiker's Guide to the Galaxy");
            book.setPrice(12.5F);
            book.setDescription("Science fiction comedy book");
            book.setIsbn("1-84173-742-2");
            book.setNbOfPage(354);
            book.setIllustrations(false);
            BookEJB itemEJB = (BookEJB) ctx.lookup("java:global/classes/BookEJB ");
            itemEJB.createBook(book);
            for (Book aBook : itemEJB.findBooks()) {
                System.out.println(aBook);
            }
        }
    }
}
