package com.examples.mapping;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@javax.persistence.Table(name = "aaaacafe")
public class Cafe implements Serializable {

  @Id
  @GeneratedValue
  @Column(name = "cafe_id")
  private int id;

  private String name;

  @OneToOne(cascade = CascadeType.ALL)
  private Barista barista;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "aaaacafe_customer",
      joinColumns = @JoinColumn(name = "cafe_id"),
      inverseJoinColumns = @JoinColumn(name = "customer_id")
  )
  private Set<Customer> customers;

  @ElementCollection
  @CollectionTable(name = "aaaaprice", joinColumns = @JoinColumn(name = "cafe_id", referencedColumnName = "cafe_id"))
  @MapKeyColumn(name = "coffee_type")
  @MapKeyClass(CoffeeType.class)
  @MapKeyEnumerated(EnumType.STRING)
  @Column(name = "price")
  private Map<CoffeeType, Double> price;

  @OneToMany(mappedBy = "cafe", cascade = CascadeType.ALL)
  private Set<Table> tables;

  public Cafe() {
  }

  public Cafe(String name, Barista barista,
      Set<Customer> customers, Map<CoffeeType, Double> price, Set<Table> tables) {
    this.name = name;
    this.barista = barista;
    this.customers = customers;
    this.price = price;
    this.tables = tables;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Barista getBarista() {
    return barista;
  }

  public void setBarista(Barista barista) {
    this.barista = barista;
  }

  public Set<Customer> getCustomers() {
    return customers;
  }

  public void setCustomers(Set<Customer> customers) {
    this.customers = customers;
  }

  public Map<CoffeeType, Double> getPrice() {
    return price;
  }

  public void setPrice(Map<CoffeeType, Double> price) {
    this.price = price;
  }

  public Set<Table> getTables() {
    return tables;
  }

  public void setTables(Set<Table> tables) {
    this.tables = tables;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cafe cafe = (Cafe) o;
    return id == cafe.id && Objects.equals(name, cafe.name) && Objects
        .equals(barista, cafe.barista) && Objects.equals(customers, cafe.customers)
        && Objects.equals(price, cafe.price) && Objects.equals(tables, cafe.tables);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, barista, customers, price, tables);
  }

  @Override
  public String toString() {
    return "Cafe{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", barista=" + barista +
        ", customers=" + customers +
        ", price=" + price +
        ", table=" + tables +
        '}';
  }
}
