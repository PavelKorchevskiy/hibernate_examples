package com.examples.mapping;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "aaaacustomer")
public class Customer implements Serializable {

  @Id
  @GeneratedValue
  @Column(name = "customer_id")
  private int id;

  private String name;

  @ManyToMany(mappedBy = "customers")
  private Set<Cafe> cafes;

  public Customer() {
  }

  public Customer(String name) {
    this.name = name;
  }

  public Customer(String name, Set<Cafe> cafes) {
    this.name = name;
    this.cafes = cafes;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Set<Cafe> getCafes() {
    return cafes;
  }

  public void setCafes(Set<Cafe> cafes) {
    this.cafes = cafes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return id == customer.id && Objects.equals(name, customer.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    return "Customer{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
