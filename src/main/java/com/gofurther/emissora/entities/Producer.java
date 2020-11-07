package com.gofurther.emissora.entities;

import javax.persistence.Entity;

@Entity
public class Producer extends User {

  public Producer() {
  }

  public Producer(String name, String email, String password) {
    super(name, email, password);
  }
}
