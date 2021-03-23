package day3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class TablePerJoinedSubclass {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Person person1 = new Person("Mostafa","Yehya");

        session.persist(person1);

        Student student = new Student("Boghday","boghdady","JETS");

        session.persist(student);

        Teacher teacher = new Teacher("Amin","amin",new Date());
        Teacher teacher2 = new Teacher("Amin2","amin2",new Date());

        session.persist(teacher);
        session.persist(teacher2);

        session.getTransaction().commit();

        // update
        session.beginTransaction();
        person1.setFirstName("yehya");
        session.update(person1);
        session.getTransaction().commit();

        // read
        session.beginTransaction();
        Person fetched = session.get(Person.class, 1);
        System.out.println("Fetched first name" +fetched.firstName);
        session.getTransaction().commit();

        // delete

        session.beginTransaction();

        session.delete(teacher);

        System.out.println("deleted teacher");

        session.getTransaction().commit();

        session.close();


    }
}
