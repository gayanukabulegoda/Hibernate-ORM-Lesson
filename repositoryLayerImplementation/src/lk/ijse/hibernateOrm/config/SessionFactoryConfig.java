package lk.ijse.hibernateOrm.config;

import lk.ijse.hibernateOrm.entity.Customer;
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
                .buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance() {
        return (factoryConfig == null) ?
                factoryConfig =  new SessionFactoryConfig() : factoryConfig;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
