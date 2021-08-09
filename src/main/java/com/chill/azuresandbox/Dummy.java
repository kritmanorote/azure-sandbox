package com.chill.azuresandbox;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dummy {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  private Integer val;

  protected Dummy() {}

  public Dummy(Integer id, Integer val) {
    this.id = id;
    this.val = val;
  }

  @Override
  public String toString() {
    return String.format(
        "Dummy[id=%d, val='%d']",
        id, val);
  }

  public Integer getId() {
    return id;
  }

  public Integer getVal() {
    return val;
  }
}