import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by levente on 2017.06.05..
 */
public class DatabaseProducer {

    @Produces
    @PersistenceContext(unitName = "ejbstuff")
    private EntityManager em;
}
