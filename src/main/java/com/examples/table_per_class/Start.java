package com.examples.table_per_class;

import com.examples.HibernateSessionFactory;
import org.hibernate.Session;

public class Start {

  public static void main(String[] args) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    CatTC cat = new CatTC("Vaska", 24);
    DogTC dog = new DogTC("Mumu", false);
    session.beginTransaction();
    session.save(cat);
    session.save(dog);
    session.getTransaction().commit();
    session.close();
  }

}
