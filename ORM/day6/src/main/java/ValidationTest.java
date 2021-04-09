import entity.Student;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.Set;

public class ValidationTest {

    public static void main(String[] args) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Student student = new Student();

        student.setAge(12);
        student.setEmail("llll");
        student.setBirthDate(new Date());
        student.setWorking(false);

        Set<ConstraintViolation<Student>> violations = validator.validate(student);


        for (ConstraintViolation<Student> violation :
                violations) {
            System.out.println(violation.getMessage());
        }
l
    }
}
