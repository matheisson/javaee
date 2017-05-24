package model2;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by levente on 2017.05.24..
 */
@Entity
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creation;
    @OneToMany(fetch = FetchType.EAGER)
    // without jColumn join table gets created
//    @JoinColumn(name = "order_fk")
    private List<OrderLine> orderLines;

    public Order() {
    }


    public Order(Date creation) {
        this.creation = creation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
