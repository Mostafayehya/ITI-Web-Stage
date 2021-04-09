package day1.lab1.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 50, nullable = false, unique = false)
    private String name;


    @Transient
    private Integer age;


    @Column(name = "email")
    private String email;

   
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "gender")
    private String gender;

    
    @Transient
    private boolean working;

    public boolean isWorking() {
        return working;
    }
  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public void setWorking(boolean working) {
        this.working = working;
    }

    public Student() {
    }

    public Student( String name, Integer age, String email, Date birthDate, String gender) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.birthDate = birthDate;
        this.gender = gender;
    }
}