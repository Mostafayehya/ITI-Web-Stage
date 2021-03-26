
import entity.Student;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class JPATest {

    public static void main(String[] args) {

             EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory( "JPATutorial" );

        EntityManager entityManager =entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new Student("ok",5,"mostafa@gmail.com",new Date(),"Male"));
        entityManager.persist(new Student("LL",10,"yehya@gmail.com",new Date(),"Male"));

        entityManager.getTransaction().commit();

        entityManager.close();


    }

}
