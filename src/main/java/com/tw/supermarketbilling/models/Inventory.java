package com.tw.supermarketbilling.models;

import java.util.List;

public class Inventory {
    private final List<Item> inventoryList;

    public Inventory(List<Item> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public Item getItemByName(String name) {
        for (Item item : inventoryList) {
            if (name.equalsIgnoreCase(item.getName())) {
                return item;
            }
        }

        return null;
    }
}
