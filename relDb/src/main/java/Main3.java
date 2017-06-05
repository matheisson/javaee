import model3.Artist;
import model3.CD;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by levente on 2017.05.25..
 */
public class Main3 {

    public static void main(String[] args) {

        Artist jimi = new Artist("Jimi", "Hendrix");
        Artist mitch = new Artist("Mitch", "Mitchel");
        Artist noel = new Artist("Noel", "Redding");
        Artist buddy = new Artist("Buddy", "Miles");

        CD electric = new CD("Electric Ladyland", "thrid", 28.6f);
        CD aye = new CD("Are you Experienced?", "thrid", 28.6f);
        CD axis = new CD("Bold as Love", "thrid", 28.6f);
        CD fillmore = new CD("Fillmore East", "Live set", 23f);

        buddy.setAppearsOnCds(Arrays.asList(fillmore));
        jimi.setAppearsOnCds(Arrays.asList(electric,fillmore,axis,aye));
        noel.setAppearsOnCds(Arrays.asList(electric,fillmore,axis,aye));
        mitch.setAppearsOnCds(Arrays.asList(electric,fillmore,axis,aye));

        EntityManager emf = Persistence.createEntityManagerFactory("manytomany").createEntityManager();
        EntityTransaction tx = emf.getTransaction();

        tx.begin();
        emf.persist(jimi);
        emf.persist(noel);
        emf.persist(mitch);
        emf.persist(buddy);
        emf.persist(aye);
        emf.persist(axis);
        emf.persist(electric);
        emf.persist(fillmore);
        tx.commit();

        Artist jim = (Artist) emf.createNativeQuery("SELECT * from ARTIST a where lastName = 'Hendrix'", Artist.class).getSingleResult();

        CD axiscd = (CD) emf.createNativeQuery("SELECT * from CD a where title = 'Bold as Love'", CD.class).getSingleResult();


        List<CD> stuff = jim.getAppearsOnCds();

        //System.out.println(axiscd.getCreatedByArtists().get(0).getFirstName());

        for (CD cd: stuff) {
            System.out.println(cd.getTitle());
        }

        System.out.println('\n');

        Artist miles = new Artist("Miles", "Davis");

        tx.begin();
        emf.persist(miles);
        miles.setFirstName("Miles III");
        tx.commit();

        TypedQuery<Artist> queryWithParameter = emf.createQuery("SELECT a from Artist a where a.firstName = ?1", Artist.class);
        queryWithParameter.setParameter(1,"Jimi");
        Artist j = queryWithParameter.getSingleResult();

        TypedQuery<Artist> noelR = emf.createNamedQuery(Artist.FIND_ONE, Artist.class).setParameter("name","Noel");
        Artist n = noelR.getSingleResult();

        System.out.println(n.getLastName());

        System.out.println(j.toString());
    }

}
