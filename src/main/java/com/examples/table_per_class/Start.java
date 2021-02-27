package com.examples.table_per_class;

import com.examples.HibernateSessionFactory;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
    System.out.println(getAllAnimals());
  }

  private static List<AnimalTC> getAllAnimals() {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    Query<AnimalTC> query = session.createQuery("from AnimalTC ");
    return query.list();
  }

}
