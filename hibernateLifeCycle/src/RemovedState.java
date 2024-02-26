import lk.ijse.hibernateOrm.config.SessionFactoryConfig;
import lk.ijse.hibernateOrm.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RemovedState {

    public static void main(String[] args) {

        Session session = SessionFactoryConfig.getInstance().getSession();
        Customer customer = session.get(Customer.class, 5);
        boolean isContains = session.contains(customer);

        isContain(isContains);

        //Removed State
        System.out.println("\n===========Removed State===========\n");
        Transaction transaction = session.beginTransaction();
        session.delete(customer);
        transaction.commit();
        boolean contains = session.contains(customer);
        isContain(contains);

        session.close();
    }

    private static void isContain(boolean isContains) {
        if (isContains) {
            System.out.println("Customer is in Persistent State");
        } else {
            System.out.println("Customer is in Removed State");
        }
    }
}
