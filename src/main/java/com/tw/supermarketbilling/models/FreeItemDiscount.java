package com.tw.supermarketbilling.models;

public class FreeItemDiscount implements DiscountStrategy {
    private final int minimumBuyingQuantity;
    private final int freeQuantity;

    public FreeItemDiscount(int minimumBuyingQuantity, int freeQuantity) {
        this.minimumBuyingQuantity = minimumBuyingQuantity;
        this.freeQuantity = freeQuantity;
    }

    public int calculateDiscountAmount(int quantity, int pricePerUnit) {
        int totalFreeAmount = 0;

        if (quantity > minimumBuyingQuantity + freeQuantity) {
            totalFreeAmount = ((minimumBuyingQuantity + freeQuantity) / quantity) * freeQuantity;

        } else if (quantity > minimumBuyingQuantity) {
            totalFreeAmount = minimumBuyingQuantity - quantity;
        }

        int discountAmount = totalFreeAmount * pricePerUnit;
        return discountAmount;
    }
}
