package day2.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchingStrategiesTest {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Seller seller = (Seller) session.load(Seller.class, 2);

    //    seller.getProducts();
        session.getTransaction().commit();

    }


}
