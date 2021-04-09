package day1;


import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("employees")
public class EmployeeController {

    public static  EmployeeRepository repo = 
    EmployeeRepository.getInstance();

    @POST
    public Employee createEmployee(Employee emp) {
       return repo.createEmployee(emp);
    }

    @GET
    @Path("{id}")
    public Employee getEmployeeById(@PathParam("id") id){
        return repo.getEmployeeById(id);
    }

    @PUT
    @Path("{id}")
    public Employee updateEmployee(@PathParam("id") int id,Employee emp){
        return repo.updateEmployee(emp);
    }


    @DELETE
    @Path("{id}")
    public Employee deleteEmployeeById(@PathParam("id") int id){
        return repo.deleteEmployeeById(id);
    }



}
