package com.gofurther.emissora.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Producer extends User {

  public Producer() {
    super(true);
  }

  public Producer(String name, String email, String password) {
    super(name, true, email, password);
  }
}
