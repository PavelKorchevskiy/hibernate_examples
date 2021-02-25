package com.examples;

import com.examples.joined_table.AnimalJ;
import com.examples.joined_table.CatJ;
import com.examples.joined_table.DogJ;
import com.examples.mapping.Barista;
import com.examples.mapping.Cafe;
import com.examples.mapping.Customer;
import com.examples.mapping.Table;
import com.examples.single_table.Animal;
import com.examples.single_table.Cat;
import com.examples.single_table.Dog;
import com.examples.table_per_class.AnimalTC;
import com.examples.table_per_class.CatTC;
import com.examples.table_per_class.DogTC;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

  private static SessionFactory sessionFactory;

  private HibernateSessionFactory() {
  }

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      synchronized (HibernateSessionFactory.class) {
        if (sessionFactory == null) {
          Configuration configuration = new Configuration().configure();
          //inheritance
          configuration.addAnnotatedClass(Animal.class);
          configuration.addAnnotatedClass(Dog.class);
          configuration.addAnnotatedClass(Cat.class);
          configuration.addAnnotatedClass(AnimalJ.class);
          configuration.addAnnotatedClass(CatJ.class);
          configuration.addAnnotatedClass(DogJ.class);
          configuration.addAnnotatedClass(AnimalTC.class);
          configuration.addAnnotatedClass(DogTC.class);
          configuration.addAnnotatedClass(CatTC.class);
          //mapping
          configuration.addAnnotatedClass(Cafe.class);
          configuration.addAnnotatedClass(Barista.class);
          configuration.addAnnotatedClass(Customer.class);
          configuration.addAnnotatedClass(Table.class);

          StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
              .applySettings(configuration.getProperties());
          sessionFactory = configuration.buildSessionFactory(builder.build());
        }
      }
    }
    return sessionFactory;
  }
}
