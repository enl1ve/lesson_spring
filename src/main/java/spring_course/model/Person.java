package spring_course.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "not empty!")
    @Size(min = 2, max = 30, message = "mala/mnoga")
    @Column(name = "name")
    private String name;

    @Min(value = 0, message = "mala")
    @Max(value = 100, message = "mnoga")
    @Column(name = "age")
    private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
