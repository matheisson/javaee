package model;

import javax.persistence.*;

/**
 * Created by levente on 2017.05.24..
 */
@Entity
@Table(name = "shipping_address")
public class Address {

    @Id
    @GeneratedValue
    private Long id;
    private String city;
    private String street;
    private Integer number;
    @OneToOne(mappedBy = "address")
    private Customer customer;


    public Address() {
    }


    public Address(String city, String street, Integer number) {
        this.city = city;
        this.street = street;
        this.number = number;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
