package com.examples.joined_table;

import java.util.Objects;
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
    DogJ dogJ = (DogJ) o;
    return isGoodBoy == dogJ.isGoodBoy;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), isGoodBoy);
  }

  @Override
  public String toString() {
    return "DogJ{" +
        "id=" + getId() +
        ", name=" + getName() +
        ", isGoodBoy=" + isGoodBoy +
        '}';
  }
}
