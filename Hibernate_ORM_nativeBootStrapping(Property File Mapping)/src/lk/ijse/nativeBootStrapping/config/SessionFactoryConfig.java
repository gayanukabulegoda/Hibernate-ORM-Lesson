package lk.ijse.nativeBootStrapping.config;

import lk.ijse.nativeBootStrapping.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;

    private SessionFactoryConfig() {}

    public static SessionFactoryConfig getInstance() {
        return (factoryConfig == null) ?
                factoryConfig = new SessionFactoryConfig() : factoryConfig;
    }

    public Session getSession() {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .loadProperties("hibernate.properties")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Employee.class).getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.buildSessionFactory();

        return sessionFactory.openSession();
    }
}
