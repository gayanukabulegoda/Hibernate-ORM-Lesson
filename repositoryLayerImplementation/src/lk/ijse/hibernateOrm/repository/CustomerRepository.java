package lk.ijse.hibernateOrm.repository;

import lk.ijse.hibernateOrm.entity.Customer;
import lk.ijse.hibernateOrm.config.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerRepository {

    private final Session session;

    public CustomerRepository() {
        session = SessionFactoryConfig.getInstance().getSession();
    }

    public int saveCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();
        try {
            int customerId = (int) session.save(customer);
            transaction.commit();
            return customerId;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            //throw e;
            //throw the exception to controller layer in projects with UI inorder to see the exception to user
            return -1;
        } finally {
            session.close();
        }
    }

    public Customer getCustomer(int id) throws RuntimeException {
        try {
            Customer customer = session.get(Customer.class, id);
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            session.close();
        }
    }

    public boolean updateCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();
        try {
            session.update(customer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    public boolean deleteCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(customer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

}
