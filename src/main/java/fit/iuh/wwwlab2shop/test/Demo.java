package fit.iuh.wwwlab2shop.test;

import fit.iuh.wwwlab2shop.db.JPAConnection;
import fit.iuh.wwwlab2shop.models.Customer;
import fit.iuh.wwwlab2shop.repositories.CustomerRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.dialect.Dialect;
import org.mariadb.jdbc.Driver;

public class Demo {

    public static void main(String[] args) {
        EntityManager em = JPAConnection.getInstance().getEm();
//        CustomerRepository customerRepository = new CustomerRepository();

    }

}
