package spring_course.dao;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring_course.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
    private List<Person> people;
    private static int PEOPLE_COUNT;

    {
        people = new ArrayList<Person>();

        people.add(new Person(++PEOPLE_COUNT, "Rom"));
        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Mike"));
        people.add(new Person(++PEOPLE_COUNT, "Viki"));

    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
