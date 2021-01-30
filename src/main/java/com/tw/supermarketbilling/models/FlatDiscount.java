package com.tw.supermarketbilling.models;

public class FlatDiscount implements DiscountStrategy {
    private final int discountPercent;

    private final static int HUNDRED = 100;

    public FlatDiscount(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int calculateDiscountAmount(int quantity, int pricePerUnit) {
        int totalCost = quantity * pricePerUnit;
        int flatDiscount = (discountPercent * totalCost) / HUNDRED;

        return flatDiscount;
    }
}