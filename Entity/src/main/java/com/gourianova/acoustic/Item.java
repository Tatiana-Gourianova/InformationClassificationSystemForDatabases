package com.gourianova.acoustic;


import java.math.BigDecimal;
import java.util.Objects;


public class Item extends Entity {


    private long id;
    private String name;//материал
    private String model;//iD
    private BigDecimal thickness;//mm  //characteristics (id==1) in units (id==1)
    private BigDecimal density;// kg/m3 //characteristics (id==2) in units (id==2)


    private int si63;
    private int si125;
    private int si250;
    private int si500;
    private int si1000;
    private int si2000;
    private int si4000;
    private int si8000;

    public Item(int id, String name, String model, BigDecimal thickness, BigDecimal density, int si63, int si125, int si250, int si500, int si1000, int si2000, int si4000, int si8000, BigDecimal averagedSI, int typeId, int unitId, String unit, String type, String description, String color) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.thickness = thickness;
        this.density = density;
        this.si63 = si63;
        this.si125 = si125;
        this.si250 = si250;
        this.si500 = si500;
        this.si1000 = si1000;
        this.si2000 = si2000;
        this.si4000 = si4000;
        this.si8000 = si8000;
        AveragedSI = averagedSI;
        this.typeId = typeId;
        this.unitId = unitId;
        this.unit = unit;
        this.type = type;
        this.description = description;
        this.color = color;
    }



    public BigDecimal getAveragedSI() {
        return AveragedSI;
    }

    public void setAveragedSI(BigDecimal averagedSI) {
        AveragedSI = averagedSI;
    }

    private BigDecimal AveragedSI;
    private int typeId;//ConstructId
    private int unitId;//UnitId color?
    //TODO: расписать значимые характеристики
    private String unit;//Construct
    private String type;//Sandwich
    private String description;
    private String color;
    public Item() {
    }

    public Item(int id, String name, String model, BigDecimal thickness, BigDecimal density, int typeId, int unitId, String type, String unit, String color, String description) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.thickness = thickness;
        this.density = density;

        this.typeId = typeId;
        this.unitId = unitId;
        this.type = type;
        this.unit = unit;
        this.color = color;
        this.description = description;
    }
    public int getSi63() {
        return si63;
    }

    public void setSi63(int si63) {
        this.si63 = si63;
    }

    public int getSi125() {
        return si125;
    }

    public void setSi125(int si125) {
        this.si125 = si125;
    }

    public int getSi250() {
        return si250;
    }

    public void setSi250(int si250) {
        this.si250 = si250;
    }

    public int getSi500() {
        return si500;
    }

    public void setSi500(int si500) {
        this.si500 = si500;
    }

    public int getSi1000() {
        return si1000;
    }

    public void setSi1000(int si1000) {
        this.si1000 = si1000;
    }

    public int getSi2000() {
        return si2000;
    }

    public void setSi2000(int si2000) {
        this.si2000 = si2000;
    }

    public int getSi4000() {
        return si4000;
    }

    public void setSi4000(int si4000) {
        this.si4000 = si4000;
    }

    public int getSi8000() {
        return si8000;
    }

    public void setSi8000(int si8000) {
        this.si8000 = si8000;
    }

    public BigDecimal getDensity() {
        return density;
    }

    public void setDensity(BigDecimal density) {
        this.density = density;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public long getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getThickness() {
        return thickness;
    }

    public void setThickness(BigDecimal thickness) {
        this.thickness = thickness;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getId() == item.getId() &&
                Objects.equals(getName(), item.getName()) &&
                Objects.equals(getModel(), item.getModel()) &&
                getThickness() == item.getThickness() &&
                Objects.equals(getDensity(), item.getDensity()) &&
                Objects.equals(getType(), item.getType()) &&
                Objects.equals(getUnit(), item.getUnit()) &&
                Objects.equals(getColor(), item.getColor()) &&
                Objects.equals(getDescription(), item.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getModel(), getThickness(), getDensity(), getType(), getUnit(), getColor(), getDescription());
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", Name='" + name +
                ", Model='" + model +
                ", Thickness='" + thickness +
                ", Density='" + density +
                ", Type='" + type +
                ", Unit='" + unit +
                ", Color='" + color +
                ", Description='" + description +


                '}' + super.toString();
    }

    public void setAveragedSI(String string) {
    }
}