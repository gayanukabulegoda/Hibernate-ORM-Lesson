import lk.ijse.hibernateOrm.config.SessionFactoryConfig;
import lk.ijse.hibernateOrm.entity.Customer;
import org.hibernate.Session;

public class TransientState {

    public static void main(String[] args) {
        Session session = SessionFactoryConfig
                .getInstance()
                .getSession();

        //Transient State
        System.out.println("\n===========Transient State===========\n");
        Customer customer = new Customer();
        customer.setId(3);
        customer.setName("Richard");
        customer.setAddress("Tangalle");

        boolean isContain = session.contains(customer);

        if (isContain) {
            System.out.println("This object is not in Transient state");
        } else {
            System.out.println("This object is in Transient state");
        }
        session.close();
    }
}
