package com.examples.single_table;

import com.examples.HibernateSessionFactory;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class Start {

  public static void main(String[] args) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    Cat cat = new Cat("Vaska", 24);
    Dog dog = new Dog("Mumu", false);
    session.beginTransaction();
    session.save(cat);
    session.save(dog);
    session.getTransaction().commit();
    session.close();
    System.out.println(getAllAnimals());
  }

  private static List<Animal> getAllAnimals() {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    Query<Animal> query = session.createQuery("from Animal ");
    return query.list();
  }
}
