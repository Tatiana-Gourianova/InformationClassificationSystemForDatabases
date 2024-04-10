package com.gourianova.acoustic;

import java.util.Objects;


public class Material extends Entity {
    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", unit='" + unit + '\'' +
                ", source='" + source + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    private int id;
    private String unit;
    private String source;
    private String url;

    public Material(int id, String unit, String source, String url) {
        this.id = id;
        this.unit = unit;
        this.source = source;
        this.url = url;
    }

    public Material() {
    }

    public Material(int id, String unit) {
        this.id = id;
        this.unit = unit;

    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Material)) return false;
        Material material = (Material) o;
        return getId() == material.getId() && Objects.equals(getUnit(), material.getUnit()) && Objects.equals(getSource(), material.getSource()) && Objects.equals(getUrl(), material.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUnit(), getSource(), getUrl());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


}
