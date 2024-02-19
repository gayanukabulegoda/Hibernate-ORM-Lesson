package lk.ijse.orm_nativeBootStrapping;

import lk.ijse.orm_nativeBootStrapping.config.SessionFactoryConfig;
import lk.ijse.orm_nativeBootStrapping.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer {
    public static void main(String[] args) {

        Session session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setId(2);
        customer.setName("Amal");
        customer.setAddress("Rathnapura");
        customer.setSalary(65000.00);

        session.save(customer);
        transaction.commit();
        session.close();
    }
}
