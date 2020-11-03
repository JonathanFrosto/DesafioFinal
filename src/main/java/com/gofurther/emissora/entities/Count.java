package com.gofurther.emissora.entities;

import java.util.Objects;

public class Count<T> {
    private T thing;
    private Integer frequency;

    public Count() {
    }

    public Count(T thing, int frequency) {
        this.thing = thing;
        this.frequency = frequency;
    }

    public T getThing() {
        return thing;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setThing(T thing) {
        this.thing = thing;
    }

    public void add() {
        frequency += 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count<?> count = (Count<?>) o;
        return thing.equals(count.thing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(thing);
    }
}
