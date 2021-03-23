package day3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class TablePerConcereteClassStrategyMain {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Person person1 = new Person("Mostafa","Yehya");
        Person person2 = new Person("Masnour","Ahmed");

        session.persist(person1);
        session.persist(person2);

        Student student = new Student("sssss","sssss","physics");
        Student student1 = new Student("sssss2","sssss2","math");

        session.persist(student);
        session.persist(student1);


        Teacher teacher = new Teacher("t","t",new Date());
        Teacher Teacher2 = new Teacher("tt","tt",new Date());

        session.persist(teacher);
        session.persist(Teacher2);

        session.getTransaction().commit();

        // update
        session.beginTransaction();
        person1 = new Person("pp","pp");
        person1.setId(1);
        session.update(person1);
        session.getTransaction().commit();

        // read
        session.beginTransaction();
        Person fetched = session.get(Person.class, 1);
        System.out.println(fetched);
        session.getTransaction().commit();

        // delete

        session.beginTransaction();

        session.delete(teacher);

        System.out.println("deleted teacher");

        session.getTransaction().commit();

        session.close();








    }
}
