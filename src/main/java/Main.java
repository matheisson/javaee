import model.Address;

import javax.persistence.*;
import java.util.List;

/**
 * Created by levente on 2017.05.23..
 */
public class Main {

    public static void main(String[] args) {
        Address add1 = new Address("Budapest","Nagymező", 34, "Pest");
        Address add2 = new Address("Miskolc","Posta", 23, "BAZ");
        Address add3 = new Address("Boldog","Rákóczi", 4, "Heves");
        Address add4 = new Address("Budapest","Kunigunda", 2, "Pest");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("onetowhatever");
        EntityManager em = emf.createEntityManager();

        EntityTransaction etx = em.getTransaction();

        etx.begin();
        em.persist(add1);
        em.persist(add2);
        em.persist(add3);
        em.persist(add4);
        etx.commit();

        List<Address> addresses = em.createNamedQuery("findByTown", Address.class).getResultList();

        Address bol = (Address) em.createNativeQuery("SELECT * FROM ADDRESS where city = 'Boldog'", Address.class).getSingleResult();

        Query q = em.createNativeQuery("SELECT a.city, a.street from Address a");


        List<Object[]> ad = q.getResultList();

        System.out.println("\nNamed query result:");
        System.out.println(addresses.get(0).toString());

        System.out.println("\nNative query casted to Address:");
        System.out.println(bol.toString());

        System.out.println("\nQuery object results:");
        for (Object[] a: ad) {
            System.out.println(a[0]+" "+a[1]);
        }

    }
}
