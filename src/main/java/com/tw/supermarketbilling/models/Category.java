package com.tw.supermarketbilling.models;

public class Category {

    private final String name;
    private final DiscountStrategy discountStrategy;

    public Category(String name, DiscountStrategy discountStrategy) {
        this.name = name;
        this.discountStrategy = discountStrategy;
    }

    int calculateDiscountAmount(int quantity, int pricePerUnit) {
        return discountStrategy.calculateDiscountAmount(quantity, pricePerUnit);
    }
}