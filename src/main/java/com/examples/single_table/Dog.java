package com.examples.single_table;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("pios")
public class Dog extends Animal {

  @Column(name = "isGoodBoy")
  private boolean isGoodBoy;

  //all dogs default good boys)
  public Dog() {
    this.isGoodBoy = true;
  }

  public Dog(String name, boolean isGoodBoy) {
    super(name);
    this.isGoodBoy = isGoodBoy;
  }

  public boolean isGoodBoy() {
    return isGoodBoy;
  }

  public void setGoodBoy(boolean goodBoy) {
    isGoodBoy = goodBoy;
  }
}
