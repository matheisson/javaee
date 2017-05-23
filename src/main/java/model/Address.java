package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by levente on 2017.05.23..
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "findByTown", query = "select a from Address a where a.city ='Budapest'"),
        @NamedQuery(name = "selectNum", query = "select a from Address a where a.nom >24")
})
public class Address {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String city;
    private String street;
    private Integer nom;
    private String county;

    public Address() {
    }

    public Address(String city, String street, Integer no, String county) {
        this.city = city;
        this.street = street;
        this.nom = no;
        this.county = county;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNo() {
        return nom;
    }

    public void setNo(Integer no) {
        this.nom = no;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public String toString() {
        return "Address: "+getCounty()+", "+getCity()+", "+getStreet()+", "+getNo();
    }
}
