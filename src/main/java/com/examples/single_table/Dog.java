package com.examples.single_table;

import java.util.Objects;
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
    Dog dog = (Dog) o;
    return isGoodBoy == dog.isGoodBoy;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), isGoodBoy);
  }

  @Override
  public String toString() {
    return "Dog{" +
        "isGoodBoy=" + isGoodBoy +
        "} " + super.toString();
  }
}
