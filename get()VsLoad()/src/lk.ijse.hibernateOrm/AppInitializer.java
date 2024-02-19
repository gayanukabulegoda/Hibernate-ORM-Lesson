package lk.ijse.hibernateOrm;

import lk.ijse.hibernateOrm.entity.Customer;
import lk.ijse.hibernateOrm.repository.CustomerRepository;

public class AppInitializer {
    public static void main(String[] args) {

        //1.Save
        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.saveCustomer(getCustomer());

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
    }

    private static Customer getCustomer() {
        Customer customer = new Customer();
        //customer.setId(1);
        customer.setName("Nisal");
        customer.setAddress("Rathnapura");
        return customer;
    }

}
