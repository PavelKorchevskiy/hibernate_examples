package com.examples.joined_table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "dogId")
public class DogJ extends AnimalJ {

  @Column(name = "isGoodBoy")
  private boolean isGoodBoy;

  //all dogs default good boys)
  public DogJ() {
    this.isGoodBoy = true;
  }

  public DogJ(String name, boolean isGoodBoy) {
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
