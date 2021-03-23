package day1.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;



public class TestingAnnotation {

        public static void main(String[] args) {
            SessionFactory sessionFactory = new Configuration()
                    .configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            day1.annotation.Account account = new Account();
            account.setUserName("Mostafaannotation");
            account.setFullName("Mostafa Yehya Mansour");
            account.setPassword("00000000000");
            account.setPhone("0235355637");
            account.setBirthday(new Date());
            session.beginTransaction();
            session.persist(account);
            session.getTransaction().commit();
            System.out.println("Insertion Done");
        }

}
