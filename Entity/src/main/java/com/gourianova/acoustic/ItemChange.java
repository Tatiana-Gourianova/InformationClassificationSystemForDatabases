package com.gourianova.acoustic;

import java.util.Objects;


public class ItemChange extends Entity {
    private int id;

    private int itemId;
    private int userId;

    public ItemChange(int id, int i) {

        this.itemId=id;
        this.userId=i;
    }

    public ItemChange() {

    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemChange)) return false;
        ItemChange itemChange = (ItemChange) o;
        return getId() == itemChange.getId() &&
                getItemId() == itemChange.getItemId() &&
                getUserId() == itemChange.getUserId();

    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getItemId(), getUserId());
    }

    @Override
    public String toString() {
        return "ItemChange{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", userId=" + userId +
                "} " + super.toString();
    }
}
