package ru.progwards.java1.lessons.register1;

import java.util.Objects;

public class Bit {

    private boolean value;

    public Bit() {
        value = false;
    }

    public Bit(boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bit bit = (Bit) o;
        return value == bit.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value ? "1" : "0";
    }
}
