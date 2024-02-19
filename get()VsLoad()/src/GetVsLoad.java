import lk.ijse.hibernateOrm.config.SessionFactoryConfig;
import lk.ijse.hibernateOrm.entity.Customer;
import org.hibernate.Session;

public class GetVsLoad {
    public static void main(String[] args) {
        Session session = SessionFactoryConfig.getInstance().getSession();

        Customer customer = new Customer();

        customer.setName("Wimal");
        customer.setAddress("Matara");
        session.save(customer);
        session.close();

        // 1.Get

        Session getSession = SessionFactoryConfig.getInstance().getSession();
        System.out.println("------------ GET -----------");
        Customer getCustomer = getSession.get(Customer.class, 1);
        System.out.println("Customer Id of Get: " + getCustomer.getId());
        System.out.println("Customer Name of Get: " + getCustomer.getName());
        getSession.close();

        // 2.Load

        Session loadSession = SessionFactoryConfig.getInstance().getSession();
        System.out.println("------------ LOAD -----------");
        Customer loadCustomer = loadSession.load(Customer.class, 1);
        System.out.println("Customer Id of Load: " + loadCustomer.getId());
        System.out.println("Customer Name of Load: " + loadCustomer.getName());
        loadSession.close();
    }
}
