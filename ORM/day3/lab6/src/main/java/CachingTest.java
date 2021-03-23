import day2.dao.Seller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CachingTest {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session firstSession = sessionFactory.openSession();
        Session secondSession = sessionFactory.openSession();

        Seller s = firstSession.load(Seller.class, 2);
        Seller s1 = secondSession.load(Seller.class, 2);



    }


}
