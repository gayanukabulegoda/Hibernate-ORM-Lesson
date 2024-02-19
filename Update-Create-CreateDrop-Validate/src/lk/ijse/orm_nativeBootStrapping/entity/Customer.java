package lk.ijse.orm_nativeBootStrapping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
@Entity(name = "customer")
        - - - OR - - -      */
@Entity
@Table(name = "customer")
public class Customer {

    @Id // Says Hibernate that 'private int id' should be the primary key
    @Column(name = "customer_id")
    private int id;
    @Column(name = "customer_name")
    private String name;
    @Column(name = "customer_address")
    private String address;
    @Column(name = "customer_salary")
    private double salary;
    @Column(name = "customer_mobileNo")
    private int mobileNumber;

    public Customer() {}

    public Customer(int id, String name, String address, double salary, int mobileNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.mobileNumber = mobileNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }
}
