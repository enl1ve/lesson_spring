package spring_course.model;

import javax.validation.constraints.*;

public class Person {
    private int id;

    @NotEmpty(message = "not empty!")
    @Size(min = 2, max = 30, message = "mala/mnoga")
    private String name;
    @NotEmpty(message = "not empty!")
    @Email(message = "email!!")
    private String email;
    @Min(value = 0, message = "mala")
    @Max(value = 100, message = "mnoga")
    private int age;


    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Person() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
