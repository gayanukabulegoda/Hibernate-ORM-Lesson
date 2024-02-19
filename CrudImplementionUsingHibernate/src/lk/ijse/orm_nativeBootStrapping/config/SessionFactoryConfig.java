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

    private SessionFactoryConfig() {}

    public static SessionFactoryConfig getInstance() {
        return (factoryConfig == null) ?
                factoryConfig =  new SessionFactoryConfig() : factoryConfig;
    }

    public Session getSession(){
        /*
         * Step 01:- Service Registry Creation
         */
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                /*
                 * configures (reads) hibernate.cfg.xml file;
                 * from its path if it is in src root no need to mention path,
                 * but if it is present inside a package; need to mention the path as an argument
                 */
                .configure()
                .build();

        /*
         * Step 02: Creates MetaData
         * And build it
         */
        Metadata metaData =
                new MetadataSources(serviceRegistry).
                        addAnnotatedClass(Customer.class).getMetadataBuilder().build();

        /*
         * Step 03: Creates session factory
         */
        SessionFactory sessionFactory = metaData.buildSessionFactory();

        /*
         * Step 04: Creates and open the session
         * Opened session creates and returns
         * So we should be responsible to close the session;
         * After session's work done
         */
        return sessionFactory.openSession();
    }
}
