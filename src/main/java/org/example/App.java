package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Hibernate;
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
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
//Тип EAGER
           /* Item item = session.get(Item.class, 1);
            System.out.println("Получили товар");

            //Получаем связаные данные
            System.out.println(item.getOwner()); */


//Тип LAZY
           /* Person person = session.get(Person.class, 1);
            System.out.println("Получили человека");

            //получаем связаные сущности
            System.out.println(person.getItems()); */

//После сменны fetch на EAGER
            Person person = session.get(Person.class, 1);
            System.out.println("Получили человека из таблицы");
            //System.out.println(person);
            //Получаем связаные данные
            //System.out.println(person.getItems());
            //Hibernate.initialize(person.getItems()); //Подгружаем связаные ленивые сущности

            session.getTransaction().commit();

            System.out.println("Конец первой транзакции");

            //Открываем сессии и транзакцию, можем сделать в любом месте в коде
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Внутри второй транзакции");

            person = session.merge(person);//привязываем к текущей сессии

            Hibernate.initialize(person.getItems());

            session.getTransaction().commit();

            System.out.println("Вне сессии второй сессии");
            //session.close()
//Даже в не сессии товары можем получать потому что они были уже подгруженны
//С LAZY так не работает потому что не подгружаются связанные данные
           System.out.println(person.getItems());
        }
    }
}
