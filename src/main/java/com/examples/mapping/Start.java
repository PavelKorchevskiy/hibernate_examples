package com.examples.mapping;

import com.examples.HibernateSessionFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class Start {

  public static void main(String[] args) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    List<Cafe> cafes = initCafes();
    session.beginTransaction();
    for (Cafe cafe : cafes) {
      session.save(cafe);
    }
    session.getTransaction().commit();
    //HQL
    Query<Cafe> query = session.createQuery("from Cafe where barista.name = :name");
    query.setParameter("name", "Natasha");
    System.out
        .println("_______ " + query.stream().findAny().orElseThrow(IllegalArgumentException::new));
    //criteria
    System.out.println("__________________________________-");
    Criteria criteria = session.createCriteria(Barista.class)
        .add(Restrictions.eq("name", "Jaugen"));
    criteria.list().forEach(System.out::println);
    System.out.println("__________________________________-");
    //criteria 2.0
    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    CriteriaQuery<Table> criteriaQuery = criteriaBuilder.createQuery(Table.class);
    Root<Table> root = criteriaQuery.from(Table.class);
    criteriaQuery.select(root).where(criteriaBuilder.gt(root.get("size"), 3));
    Query<Table> query1 = session.createQuery(criteriaQuery);
    query1.stream().forEach(System.out::println);
    session.close();
  }


  private static List<Cafe> initCafes() {
    List<Cafe> cafes = new ArrayList<>();
    Table smallTable = new Table(2);
    Table middleTable = new Table(4);
    Table bigTable = new Table(6);
    Table smallTable1 = new Table(2);
    Table middleTable1 = new Table(4);
    Table bigTable1 = new Table(6);
    Barista barista = new Barista("Jaugen");
    Barista barista1 = new Barista("Natasha");
    Customer customerOleg = new Customer("Oleg");
    Customer customerDima = new Customer("Dima");
    Customer customerAnna = new Customer("Anna");
    Customer customerLena = new Customer("Lena");
    Map<CoffeeType, Double> price = new HashMap<>();
    price.put(CoffeeType.AMERICANO, 2.0);
    price.put(CoffeeType.CAPPUCCINO, 2.5);
    price.put(CoffeeType.ESPRESSO, 3.0);
    price.put(CoffeeType.LATTE, 2.5);
    Map<CoffeeType, Double> price1 = new HashMap<>();
    price1.put(CoffeeType.AMERICANO, 2.4);
    price1.put(CoffeeType.CAPPUCCINO, 2.7);
    price1.put(CoffeeType.ESPRESSO, 3.3);
    price1.put(CoffeeType.LATTE, 2.2);
    Cafe firstCafe = new Cafe("Community", barista,
        Set.of(customerAnna, customerLena, customerDima), price,
        Set.of(smallTable, middleTable, bigTable));
    Cafe secondCafe = new Cafe("Corn", barista1,
        Set.of(customerAnna, customerOleg, customerDima), price1,
        Set.of(smallTable1, middleTable1, bigTable1));
    barista.setCafe(firstCafe);
    barista1.setCafe(secondCafe);
    customerAnna.setCafes(Set.of(firstCafe, secondCafe));
    customerDima.setCafes(Set.of(firstCafe, secondCafe));
    customerLena.setCafes(Set.of(firstCafe));
    customerOleg.setCafes(Set.of(secondCafe));
    smallTable.setCafe(firstCafe);
    middleTable.setCafe(firstCafe);
    bigTable.setCafe(firstCafe);
    smallTable1.setCafe(secondCafe);
    middleTable1.setCafe(secondCafe);
    bigTable1.setCafe(secondCafe);
    cafes.add(firstCafe);
    cafes.add(secondCafe);
    return cafes;
  }
}
