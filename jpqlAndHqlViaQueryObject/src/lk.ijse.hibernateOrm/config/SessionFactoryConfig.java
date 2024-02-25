package lk.ijse.hibernateOrm.config;

import lk.ijse.hibernateOrm.entity.Customer;
import lk.ijse.hibernateOrm.entity.Item;
import lk.ijse.hibernateOrm.entity.Order;
import lk.ijse.hibernateOrm.entity.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfig() {
        sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(OrderDetail.class)
                .buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance() {
        return (factoryConfig == null)
                ? factoryConfig =  new SessionFactoryConfig()
                : factoryConfig;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
