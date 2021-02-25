package com.examples.single_table;

import com.examples.HibernateSessionFactory;
import org.hibernate.Session;

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
  }

}
