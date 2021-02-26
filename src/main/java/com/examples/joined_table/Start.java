package com.examples.joined_table;

import com.examples.HibernateSessionFactory;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
    System.out.println(getAnimals());
  }

  private static List<AnimalJ> getAnimals() {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    Query<AnimalJ> query = session.createQuery("from AnimalJ ");
    return query.list();
  }

}
