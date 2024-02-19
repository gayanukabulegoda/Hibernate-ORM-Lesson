package lk.ijse.orm_nativeBootStrapping.config;

import lk.ijse.orm_nativeBootStrapping.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfig() {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        Metadata metaData =
                new MetadataSources(serviceRegistry).
                        addAnnotatedClass(Customer.class).getMetadataBuilder().build();

        sessionFactory = metaData.buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance() {
        return (factoryConfig == null) ?
                factoryConfig =  new SessionFactoryConfig() : factoryConfig;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
