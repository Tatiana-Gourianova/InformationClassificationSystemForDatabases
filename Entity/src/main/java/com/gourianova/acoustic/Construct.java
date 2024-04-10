package com.gourianova.acoustic;

import java.math.BigDecimal;
import java.util.Objects;

public class Construct extends Entity {
    private int id;
    private String type;
  //  private BigDecimal price;//стоимость
  //  private String image;//поперечный срез

    public Construct() {
    }

    public Construct(int id, String type) {
        this.id = id;
        this.type = type;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Construct)) return false;
        Construct construct = (Construct) o;
        return getId() == construct.getId() &&
                Objects.equals(getType(), construct.getType());

    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getType());
    }

    @Override
    public String toString() {
        return "Construct{" +
                "id=" + id +
                ", type='" + type + '\'' +

                "} " + super.toString();
    }
}
