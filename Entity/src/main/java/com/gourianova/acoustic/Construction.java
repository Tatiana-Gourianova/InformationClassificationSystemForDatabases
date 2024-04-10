package com.gourianova.acoustic;

import java.util.Objects;

public class Construction extends Entity {
    private int id;
    private String title;

    public Construction() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Construction)) return false;
        Construction that = (Construction) o;
        return getId() == that.getId() && Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle());
    }

    public Construction(int id, String title) {
        this.id = id;
        this.title = title;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
