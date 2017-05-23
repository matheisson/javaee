import model.Address;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by levente on 2017.05.23..
 */
public class AddressTestClass {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("onetowhatever_test");

    private EntityManager em;

    private EntityTransaction etx;

    @Before
    public void setup(){
        em = emf.createEntityManager();
        etx = em.getTransaction();
    }

    @After
    public void shutDown(){
        if (em != null){
            em.close();
        }
    }

    @Test
    public void findId(){
        Address a = em.find(Address.class, 1L);
        assertEquals("Budapest",a.getCity());
    }

    @Test
    public void notNull(){
        Address a = em.find(Address.class, 1L);
        assertNotNull("not null", a);
    }

//    @Test(expected = ConstraintViolationException.class)
//    public void nullTest(){
//        Address fake = new Address(null,"kis",4,"Pest");
//        em.persist(fake);
//    }

    @Test
    public void namedQuery(){
        List<Address> bp = em.createNamedQuery("findByTown",Address.class).getResultList();
        assertEquals(3,bp.size());
    }
}
