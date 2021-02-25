package com.examples.single_table;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("mouse_killer")
public class Cat extends Animal {

  @Column(name = "numberOfDeath")
  private int countOfEatenMice;

  public Cat() {
  }

  public Cat(String name, int countOfEatenMice) {
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
