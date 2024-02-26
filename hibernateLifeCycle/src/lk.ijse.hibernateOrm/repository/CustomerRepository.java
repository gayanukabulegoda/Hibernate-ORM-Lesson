package lk.ijse.hibernateOrm.repository;

import lk.ijse.hibernateOrm.config.SessionFactoryConfig;
import lk.ijse.hibernateOrm.entity.Customer;
import lk.ijse.hibernateOrm.entity.Order;
import lk.ijse.hibernateOrm.projection.CustomerProjection;
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

    //Join Query Using JPQL
    public List<Order> getOrdersByCustomerID(int cusId) {
        String sql = "SELECT O FROM orders AS O\n" +
                "INNER JOIN Customer AS C ON O.customer.id = C.id\n" +
                "WHERE O.customer.id = :cus_id";

        Query query = session.createQuery(sql);
        query.setParameter("cus_id", cusId);

        List<Order> list = query.list();
        session.close();
        return list;
    }

    //Join Query Using HQL
    public List<Customer> getCustomerHQL() {
        String sql = "FROM Customer";
        Query query = session.createQuery(sql);
        List<Customer> list = query.list();
        session.close();
        return list;
    }

    //Constructor Projection Using JPQL
    public List<CustomerProjection> getCustomerProjection() {
        String sql = "SELECT \n" +
                "new lk.ijse.hibernateOrm.projection.CustomerProjection(C.id, C.name) \n" +
                "FROM Customer AS C";

        Query query = session.createQuery(sql);
        List<CustomerProjection> list = query.list();
        session.close();
        return list;
    }

}
