package lk.ijse.hibernateOrm.entity;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;
    @Column(name = "order_description")
    private String description;
    @UpdateTimestamp
    @Column(name = "order_date_time")
    private Timestamp orderDateTime;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    /*@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> items = new ArrayList<>();*/

    //ManyToMany simplified version to two 1:M relationships

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "order"
    )
    private List<OrderDetail> orderDetails = new ArrayList<>();

    public Order() {}

    public Order(int id, String description, Timestamp orderDateTime) {
        this.id = id;
        this.description = description;
        this.orderDateTime = orderDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(Timestamp orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", orderDateTime=" + orderDateTime +
                '}';
    }
}
