package com.examples.table_per_class;


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
}
