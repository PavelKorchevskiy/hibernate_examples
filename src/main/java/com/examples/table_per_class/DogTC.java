package com.examples.table_per_class;


import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("pios")
public class DogTC extends AnimalTC {

  @Column(name = "isGoodBoy")
  private boolean isGoodBoy;

  public DogTC() {
    this.isGoodBoy = true;
  }

  public DogTC(String name, boolean isGoodBoy) {
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
    DogTC dogTC = (DogTC) o;
    return isGoodBoy == dogTC.isGoodBoy;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), isGoodBoy);
  }

  @Override
  public String toString() {
    return "DogTC{" +
        "isGoodBoy=" + isGoodBoy +
        "} " + super.toString();
  }
}
