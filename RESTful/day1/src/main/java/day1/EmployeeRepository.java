package day1;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    private static List<Employee> employees = new ArrayList<>(); 

    private static EmployeeRepository INSTANCE =new EmployeeRepository();


    private EmployeeRepository(){

    }

    public static EmployeeRepository getInstance(){

            return INSTANCE ;
        }
    

    public Employee createEmployee(Employee emp){
        
        employees.add(emp);
        return emp;
    }

    public Employee getEmployeeById(int id){
        Employee emp = new Employee();
        for(int i =0;i<employees.size();i++){
            if(employees.get(i).getId() == id)
                emp = employees.get(i);
        }
        return emp;
    }

    public Employee updateEmployee(Employee emp){

        Employee toUpdate = getEmployeeById(emp.getId()); 

        toUpdate.setName(emp.getName());
        toUpdate.setEmail(emp.getEmail());
        toUpdate.setPassword(emp.getPassword());
        toUpdate.setPhoneNumber(emp.getPhoneNumber());
        toUpdate.setSalary(emp.getSalary());
        toUpdate.setDepartment(emp.getDepartment());
        toUpdate.setUsername(emp.getUsername());
        toUpdate.setAge(emp.getAge());

        employees.remove(emp);
        employees.add(toUpdate); 

        return toUpdate; 
    }

    public Employee deleteEmployeeById(int id){
        Employee toDelete = getEmployeeById(id);

        employees.remove(toDelete);

        return toDelete;
    }
    public List<Employee> getAllEmployees(){
        return employees;
    }

   

    
}
