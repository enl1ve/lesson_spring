package spring_course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring_course.model.Item;
import spring_course.model.Person;
import spring_course.repositories.ItemRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findByItemName(String name) {
        return itemRepository.findByItemName(name);
    }

    public List<Item> findByPerson(Person person) {
        return itemRepository.findByPerson(person);
    }

}
