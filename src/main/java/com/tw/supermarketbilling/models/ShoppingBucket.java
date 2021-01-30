package com.tw.supermarketbilling.models;

import static com.tw.supermarketbilling.constants.Constants.SPACE_DELIMITER;

public class ShoppingBucket {
    private final Item item;
    private final int quantity;

    public ShoppingBucket(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return item + SPACE_DELIMITER + quantity;
    }
}
