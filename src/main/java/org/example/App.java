package org.example;

import org.example.model.Director;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory =configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
//С помощью Hibernate получите любого режиссера, а затем получите список
//его фильмов.
            /*Director director = session.get(Director.class, 2);
            System.out.println(director);

            List<Movie> movie = director.getMovies();
            System.out.println(movie);*/

//Получите любой фильм, а затем получите его режиссера.

           /*Movie movie = session.get(Movie.class, 4);
            System.out.println(movie);

            Director director = movie.getDirector();
            System.out.println(director); */

//Добавьте еще один фильм для любого режиссера.

           /*Director director = session.get(Director.class, 2);
            Movie movie = new Movie("zxcvbn", 1998, director);
            session.persist(movie);
            director.getMovies().add(movie);
            System.out.println(movie); */

//Создайте нового режиссера и новый фильм и свяжите эти сущности.

           /* Director director = new Director("David Fincher", 60);
            Movie movie = new Movie("Fight club", 1999, director);

            session.persist(director);
            session.persist(movie);

            director.setMovies(new ArrayList<>(Collections.singletonList(movie))); */

//Смените режиссера у существующего фильма.

         /* Movie movie = session.get(Movie.class, 12);
            Director director = session.get(Director.class, 7);

            movie.setDirector(director);
            session.update(movie); */

//Удалите фильм у любого режиссера.

            Director director = session.get(Director.class, 7);
            Movie movie = session.get(Movie.class, 12);

            session.remove(movie);

            director.getMovies().remove(movie);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
