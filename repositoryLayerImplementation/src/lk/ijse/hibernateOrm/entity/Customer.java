package lk.ijse.hibernateOrm.entity;

import lk.ijse.hibernateOrm.embedded.MobileNumber;
import lk.ijse.hibernateOrm.embedded.NameIdentifier;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;
    @Column(name = "customer_name")
    private NameIdentifier name;
    @Column(name = "customer_address")
    private String address;
    @Transient
    @Column(name = "customer_salary")
    private double salary;

    @ElementCollection
    @CollectionTable(
            name = "customer_mobile_NoS",
            joinColumns = @JoinColumn(name = "customer_id")
    )
    private List<MobileNumber> mobileNumbers = new ArrayList<>(); //Initializing Array List is a best practice

    @CreationTimestamp
    private Timestamp createdDateTime;

    public Customer() {}

    public Customer(int id, NameIdentifier name, String address, double salary, List<MobileNumber> mobileNumbers) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.mobileNumbers = mobileNumbers;
    }

    public NameIdentifier getName() {
        return name;
    }

    public void setName(NameIdentifier name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<MobileNumber> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name=" + name +
                ", address='" + address + '\'' +
                ", salary=" + salary +

                ", createdDateTime=" + createdDateTime +
                '}';
    }
}
