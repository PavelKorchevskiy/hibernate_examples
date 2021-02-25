package com.examples.joined_table;

import com.examples.HibernateSessionFactory;
import org.hibernate.Session;

public class Start {

  public static void main(String[] args) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    CatJ cat = new CatJ("Vaska", 24);
    DogJ dog = new DogJ("Mumu", false);
    session.beginTransaction();
    session.save(cat);
    session.save(dog);
    session.getTransaction().commit();
    session.close();
  }

}
