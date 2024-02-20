package lk.ijse.hibernateOrm.repository;

import lk.ijse.hibernateOrm.entity.Customer;
import lk.ijse.hibernateOrm.config.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

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

    //Using Native SQL Query
    public List<Object[]> getAllCustomerNative() {
        String sql = "SELECT * FROM customer";
        NativeQuery query = session.createSQLQuery(sql);
        List<Object[]> list = query.list();
        for (Object customer : list) {
            System.out.println(customer);
        }
        session.close();
        return list;
    }

    //Using JPQL Query
    public List<Customer> getAllCustomerJPQL() {
        String sql = "SELECT C FROM Customer AS C";
        Query query = session.createQuery(sql);
        List<Customer> list = query.list();
        session.close();
        return list;
    }

}
