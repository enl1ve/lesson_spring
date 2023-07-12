package ua.baklanov.Project2Boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.baklanov.Project2Boot.models.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> getBookByOwnerId(int id);

    List<Book> searchBookByTitleStartingWith(String startTitle);
}
