package com.tw.supermarketbilling.models;

import java.util.List;

public class Order {
    private final List<ShoppingBucket> itemList;
    private final Customer customer;

    public Order(List<ShoppingBucket> itemList, Customer customer) {
        this.itemList = itemList;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order [itemList = " + itemList + ", customer = " + customer + "]";
    }
}
