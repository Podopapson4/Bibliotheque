package com.podosoft.bibliotheque.Responses;

import com.podosoft.bibliotheque.Models.Item;

import java.util.List;

public class GeneralResponse {

    public String kind;
    public Integer totalItems;
    public List<Item> items;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}