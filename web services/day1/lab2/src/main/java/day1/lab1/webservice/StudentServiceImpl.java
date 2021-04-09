package day1.lab1.webservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import day1.lab1.entity.Student;
import jakarta.jws.WebService;

@WebService(endpointInterface = "day1.lab1.webservice.StudentService")
public class StudentServiceImpl implements StudentService {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPATutorial");

    EntityManager entityManager = entityManagerFactory.createEntityManager();

    List<Student> students = new ArrayList<>();

    @Override
    public Student addStudent(Student student) {

        entityManager.getTransaction().begin();

        entityManager.persist(
                new Student(student.getName(), student.getAge(), student.getEmail(), new Date(), student.getGender()));

        entityManager.getTransaction().commit();

        return student;

    }

    @Override
    public Student getStudent(Long id) {

        entityManager.getTransaction().begin();

        Student s = entityManager.find(Student.class, id);
        entityManager.getTransaction().commit();

        return s;

    }

    @Override
    public Student updateStudent(Long id, Student student) {

        entityManager.getTransaction().begin();

        Student s = entityManager.find(Student.class, id);

        int age = student.getAge();
        s.setAge(age);
        s.setEmail(student.getEmail());
        s.setGender(student.getGender());
        s.setName(student.getName());
        s.setBirthDate(student.getBirthDate());

        entityManager.getTransaction().commit();

        return entityManager.find(Student.class, id);

    }

    @Override
    public boolean deleteStudent(Long id) {

        entityManager.getTransaction().begin();

        Student s = entityManager.find(Student.class, id);

        entityManager.remove(s);

        entityManager.getTransaction().commit();

        return true;

    }

}
