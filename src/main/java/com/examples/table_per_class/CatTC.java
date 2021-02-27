package com.examples.table_per_class;


import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("mouse_killer")
public class CatTC extends AnimalTC {

  @Column(name = "numberOfDeath")
  private int countOfEatenMice;

  public CatTC() {
  }

  public CatTC(String name, int countOfEatenMice) {
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
    CatTC catTC = (CatTC) o;
    return countOfEatenMice == catTC.countOfEatenMice;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), countOfEatenMice);
  }

  @Override
  public String toString() {
    return "CatTC{" +
        "countOfEatenMice=" + countOfEatenMice +
        "} " + super.toString();
  }
}
