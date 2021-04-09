package day1;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@Table(name = "emp")
@XmlRootElement
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    @Column(name = "name")
    private String name ;

    @Column(name = "age")
    private int age;

    @Column(name = "salary")
    private int salary; 

    @Column(name = "department")
    private String department; 

    @Column(name = "address")
    private String address; 

    @Column(name = "username")
    private String username; 

    @Column(name = "password")
    private String password; 

    @Column(name = "email")
    private String email; 

    @Column(name = "phone_number")
    private String phoneNumber; 
    
}
