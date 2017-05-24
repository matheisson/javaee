package model;

import javax.persistence.*;

/**
 * Created by levente on 2017.05.24..
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
}
