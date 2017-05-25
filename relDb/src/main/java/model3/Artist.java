package model3;

import javax.persistence.*;
import java.util.List;

/**
 * Created by levente on 2017.05.25..
 */
@Entity
@NamedQuery(name = "all_cds", query = "SELECT a FROM Artist a")
public class Artist {

    @Id @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToMany
    @JoinTable(name = "artists_and_cds",
                joinColumns = @JoinColumn(name = "artist_fk"),
                inverseJoinColumns = @JoinColumn(name = "cd_fk"))
    @OrderBy("title ASC")
    private List<CD> appearsOnCds;

    public Artist() {
    }

    public Artist(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<CD> getAppearsOnCds() {
        return appearsOnCds;
    }

    public void setAppearsOnCds(List<CD> appearsOnCds) {
        this.appearsOnCds = appearsOnCds;
    }
}
