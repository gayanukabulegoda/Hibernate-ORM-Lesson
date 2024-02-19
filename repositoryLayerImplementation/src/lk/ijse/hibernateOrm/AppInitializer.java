package lk.ijse.hibernateOrm;

import lk.ijse.hibernateOrm.embedded.MobileNumber;
import lk.ijse.hibernateOrm.embedded.NameIdentifier;
import lk.ijse.hibernateOrm.entity.Customer;
import lk.ijse.hibernateOrm.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class AppInitializer {
    public static void main(String[] args) {

        //1.Save
        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.saveCustomer(getCustomer());

        //2.Get
        customerRepository = new CustomerRepository();
        Customer customer = customerRepository.getCustomer(1);
        System.out.println(customer);

        //3.update
        customerRepository = new CustomerRepository();
        customer.setAddress("Colombo");
        customerRepository.updateCustomer(customer);

        //4.delete
        customerRepository = new CustomerRepository();
        customerRepository.deleteCustomer(customer);
    }

    private static Customer getCustomer() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName(getNameIdentifier());
        //
        MobileNumber homeMobile = new MobileNumber();
        homeMobile.setType("HOME");
        homeMobile.setMobileNo("0411235997");

        MobileNumber mobileNo = new MobileNumber();
        mobileNo.setType("MOBILE");
        mobileNo.setMobileNo("0702345768");

        MobileNumber mobileNo2 = new MobileNumber();
        mobileNo2.setType("MOBILE_02");
        mobileNo2.setMobileNo("070234998");

        List<MobileNumber> mobileNumbers = new ArrayList<>();
        mobileNumbers.add(homeMobile);
        mobileNumbers.add(mobileNo);
        mobileNumbers.add(mobileNo2);
        //
        customer.setMobileNumbers(mobileNumbers);
        customer.setAddress("Rathnapura");
        customer.setSalary(65000.00);
        return customer;
    }

    private static NameIdentifier getNameIdentifier() {
        NameIdentifier nameIdentifier = new NameIdentifier();
        nameIdentifier.setFirstName("Ashen");
        nameIdentifier.setMiddleName("Sumudu");
        nameIdentifier.setLastName("Aravinda");
        return nameIdentifier;
    }
}
