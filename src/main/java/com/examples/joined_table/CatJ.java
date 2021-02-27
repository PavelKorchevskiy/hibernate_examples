package com.examples.joined_table;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "catId")
public class CatJ extends AnimalJ {

  @Column(name = "numberOfDeath")
  private int countOfEatenMice;

  public CatJ() {
  }

  public CatJ(String name, int countOfEatenMice) {
    super(name);
    this.countOfEatenMice = countOfEatenMice;
  }

  public int getCountOfEatenMice() {
    return countOfEatenMice;
  }

  public void setCountOfEatenMice(int countOfEatenMice) {
    this.countOfEatenMice = countOfEatenMice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    CatJ catJ = (CatJ) o;
    return countOfEatenMice == catJ.countOfEatenMice;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), countOfEatenMice);
  }

  @Override
  public String toString() {
    return "CatJ{" +
        "id=" + getId() +
        ", name=" + getName() +
        ", countOfEatenMice=" + countOfEatenMice +
        '}';
  }
}
