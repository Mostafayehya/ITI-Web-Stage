package day1.lab1.webservice;

import java.util.ArrayList;
import java.util.List;

import day1.lab1.entity.Student;
import jakarta.jws.WebService;

@WebService(endpointInterface = "day1.lab1.webservice.StudentService")
public class StudentServiceImpl implements StudentService {

    List<Student> students = new ArrayList<>();

    @Override
    public Student addStudent(Student student) {
        students.add(student);
        return students.get(students.size()-1);

    }

    @Override
    public Student getStudent(Long id) {

        for(Student s: students){
            if(s.getId() == id)
             return s;
        }

        return new Student();
   
    }

    @Override
    public Student updateStudent(Long id, Student student) {

        for(int i=0;i<students.size();i++){
            if(students.get(i).getId() == id){

                return students.set(i, student);
                
            }
        }
        return new Student();
    
    }

    @Override
    public boolean deleteStudent(Long id) {

        return students.removeIf(s ->s.getId() == id);

    }


}
