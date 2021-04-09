package day1.lab1.webservice;

import day1.lab1.entity.Student;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;


@WebService
public interface StudentService {


    public Student addStudent(Student student);

    public Student getStudent(Long id);

    public Student updateStudent(Long id,Student student);

    public boolean deleteStudent(Long id); 




}
