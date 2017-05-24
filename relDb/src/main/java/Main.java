import model.Address;
import model.Customer;

import javax.persistence.*;

/**
 * Created by levente on 2017.05.24..
 */
public class Main {

    public static void main(String[] args) {
        Address address = new Address("Budapest", "Akármi", 23);
        Customer customer = new Customer("Richard", "Hendricks","asd@asd.com");
        customer.setAddress(address);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("onetoone");
        EntityManager em = emf.createEntityManager();

        EntityTransaction ex = em.getTransaction();

        ex.begin();
        em.persist(address);
        em.persist(customer);
        ex.commit();

        System.out.println("Saved");

        try {
            System.out.println(address.getCustomer().getLastName());
        } catch ( Exception e){
            System.out.println("Failed");
        }
    }
}
