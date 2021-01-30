package com.tw.supermarketbilling.models;

public class SubCategory {
    private final String name;
    private final DiscountStrategy discountStrategy;

    public SubCategory(String name, DiscountStrategy discountStrategy) {
        this.name = name;
        this.discountStrategy = discountStrategy;
    }

    int calculateDiscountAmount(int quantity, int pricePerUnit) {
        return discountStrategy.calculateDiscountAmount(quantity, pricePerUnit);
    }
}