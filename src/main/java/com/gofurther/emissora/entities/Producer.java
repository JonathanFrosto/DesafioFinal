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
}
