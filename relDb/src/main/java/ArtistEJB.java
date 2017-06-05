import model3.Artist;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by levente on 2017.05.30..
 */
@Stateless
public class ArtistEJB {

    @PersistenceContext(unitName = "manytomany")
    EntityManager em;

    public void createArtist(){
        Artist art = new Artist("Jimmy", "Page");

        em.persist(art);
    }
}
