package com.examples.table_per_class;


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
}
