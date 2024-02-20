package lk.ijse.hibernateOrm.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "item_quantity")
    private int qty;
    @Column(name = "unit_price")
    private double unitPrice;

    /*@ManyToMany(mappedBy = "items")
    private List<Order> orders = new ArrayList<>();*/

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "item"
    )
    private List<OrderDetail> orderDetails = new ArrayList<>();

    public Item() {}

    public Item(int id, String itemName, int qty, double unitPrice) {
        this.id = id;
        this.itemName = itemName;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
