import model2.Order;
import model2.OrderLine;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by levente on 2017.05.24..
 */
public class Main2 {

    public static void main(String[] args) {
        OrderLine ol1 = new OrderLine("TV", 123.3d,3);
        OrderLine ol2 = new OrderLine("Radio", 23.3d,4);
        OrderLine ol3 = new OrderLine("Phone", 13.3d,1);

        Order o = new Order(new Date());

        List<OrderLine> items = new ArrayList<OrderLine>();
        items.add(ol1);
        items.add(ol2);
        items.add(ol3);

        o.setOrderLines(items);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("onetomany");
        EntityManager em = emf.createEntityManager();

        EntityTransaction ex = em.getTransaction();

        ex.begin();
        em.persist(ol1);
        em.persist(ol2);
        em.persist(ol3);
        em.persist(o);
        ex.commit();

        em.close();

        System.out.println("TV quantity: "+o.getOrderLines().get(0).getQuantity());

        System.out.println("Saved");
    }
}
