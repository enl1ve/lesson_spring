package spring_course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_course.model.Item;
import spring_course.model.Person;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByItemName(String item_name);

    List<Item> findByPerson(Person owner);
}


