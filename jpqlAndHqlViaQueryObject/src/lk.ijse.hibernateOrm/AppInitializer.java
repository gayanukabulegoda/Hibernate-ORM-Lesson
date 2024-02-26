package lk.ijse.hibernateOrm;

import lk.ijse.hibernateOrm.entity.Customer;
import lk.ijse.hibernateOrm.entity.Order;
import lk.ijse.hibernateOrm.repository.CustomerRepository;

import java.util.List;

public class AppInitializer {
    public static void main(String[] args) {

        //1.Save
        /*CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.saveCustomer(getCustomer());*/

        //2.Get
        /*customerRepository = new CustomerRepository();
        Customer customer = customerRepository.getCustomer(1);
        System.out.println(customer);

        //3.update
        customerRepository = new CustomerRepository();
        customer.setAddress("Colombo");
        customerRepository.updateCustomer(customer);*/

        //4.delete
        /*customerRepository = new CustomerRepository();
        customerRepository.deleteCustomer(customer);*/

        /*CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.getAllCustomerNative();

        customerRepository = new CustomerRepository();
        List<Customer> allCustomerJPQL = customerRepository.getAllCustomerJPQL();
        for (Customer customer : allCustomerJPQL) {
            System.out.println(customer);
        }*/

        System.out.println("\n======JPQL Join Query======\n");

        CustomerRepository customerRepository = new CustomerRepository();
        List<Order> ordersList = customerRepository.getOrdersByCustomerID(1);
        for (Order order : ordersList) {
            System.out.println(order);
        }

        System.out.println("\n======HQL Query======\n");

        customerRepository = new CustomerRepository();
        List<Customer> customerList = customerRepository.getCustomerHQL();
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    private static Customer getCustomer() {
        Customer customer = new Customer();
        //customer.setId(1);
        customer.setName("Nisal");
        customer.setAddress("Rathnapura");
        return customer;
    }

}
