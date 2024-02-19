package lk.ijse.nativeBootStrapping;

import lk.ijse.nativeBootStrapping.config.SessionFactoryConfig;
import lk.ijse.nativeBootStrapping.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer {

    public static void main(String[] args) {

        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Employee employee = new Employee();
        employee.setId(2);
        employee.setName("Elizabeth");
        employee.setAddress("Kandy");
        employee.setSalary(24500.00);

        session.save(employee);
        transaction.commit();
        session.close();
    }
}
