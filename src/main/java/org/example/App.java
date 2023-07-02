package org.example;

import org.example.model.Director;
import org.example.model.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
                .addAnnotatedClass(School.class);

        SessionFactory sessionFactory =configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
//С помощью Hibernate получите любого директора, а затем получите его школу.

            /*Director director = session.get(Director.class, 1);
            School school = director.getSchool();

            System.out.println(school);*/

//Получите любую школу, а затем получите ее директор

           /* School school = session.get(School.class, 2);
            Director director = school.getDirector();

            System.out.println(director); */

//Создайте нового директора и новую школу и свяжите эти сущности.

          /*  Director director = new Director("Director 6", 34);
            School school = new School("school 4");

            director.setSchool(school);

            session.persist(director); */

//Смените директора у существующей школы

            /* School school = session.get(School.class, 1);
            Director director = session.get(Director.class, 5);

            school.setDirector(director); */ //ошибка

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
