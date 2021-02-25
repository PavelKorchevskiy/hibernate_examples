package com.examples.mapping;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aaaabarista")
public class Barista implements Serializable {

  @Id
  @GeneratedValue
  @Column(name = "barista_id")
  private int id;

  private String name;

  @OneToOne
  @JoinColumn(name = "barista_id")
  private Cafe cafe;

  public Barista() {
  }

  public Barista(String name) {
    this.name = name;
  }

  public Barista(String name, Cafe cafe) {
    this.name = name;
    this.cafe = cafe;
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

  public Cafe getCafe() {
    return cafe;
  }

  public void setCafe(Cafe cafe) {
    this.cafe = cafe;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Barista barista = (Barista) o;
    return id == barista.id && Objects.equals(name, barista.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    return "Barista{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
