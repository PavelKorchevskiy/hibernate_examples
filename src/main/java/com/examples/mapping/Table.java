package com.examples.mapping;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@javax.persistence.Table(name = "aaaatable")
public class Table implements Serializable {

  @Id
  @GeneratedValue
  @Column(name = "table_id")
  private int id;

  private int size;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "cafe_id")
  private Cafe cafe;

  public Table() {
  }

  public Table(int size) {
    this.size = size;
  }

  public Table(int size, Cafe cafe) {
    this.size = size;
    this.cafe = cafe;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
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
    Table table = (Table) o;
    return id == table.id && size == table.size;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, size);
  }

  @Override
  public String toString() {
    return "Table{" +
        "id=" + id +
        ", size=" + size +
        '}';
  }
}
