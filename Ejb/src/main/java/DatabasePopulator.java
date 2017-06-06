import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Created by levente on 2017.06.05..
 */
@Singleton
@Startup
//@DataSourceDefinition(
//        className = "org.postgresql.ds.PGConnectionPoolDataSource",
//        name = "java:global/jdbc/jee",
//        databaseName = "jee",
//        portNumber = 5432,
//        user = "postgres",
//        password = "postgres",
//        properties = {"connectionAttributes=;create=true"}
//)
public class DatabasePopulator {

    @Inject
    private BookEJB bookEJB;

    private Book h2g2;
    private Book lord;

    @PostConstruct
    private void populateDB() {
        h2g2 = new Book("Beginning Java EE 7", 35F, "Great book", "1-8763-9125-7", 605, true);
        lord = new Book("The Lord of the Rings", 50.4f, "Adventure ", "1-84023-742-2", 1216, true);

        bookEJB.createBook(h2g2);
        bookEJB.createBook(lord);
    }

    @PreDestroy
    private void clearDB() {
        bookEJB.deleteBook(h2g2);
        bookEJB.deleteBook(lord);
    }
}
