package com.examples.table_per_class;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "animalTC")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class AnimalTC implements Serializable {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private int id;

  @Column(name = "name")
  private String name;

  public AnimalTC() {
  }

  public AnimalTC(String name) {
    this.name = name;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnimalTC animalTC = (AnimalTC) o;
    return id == animalTC.id && Objects.equals(name, animalTC.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    return "AnimalTC{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
