package com.tw.supermarketbilling.models;

import com.tw.supermarketbilling.constants.UnitOfMeasurement;

import static java.lang.Math.max;

public class Item {
    private final Category category;
    private final SubCategory subCategory;
    private final String name;
    private final int price;
    private final UnitOfMeasurement unitOfMeasurement;
    private final DiscountStrategy itemDiscount;

    public Item(Category category, SubCategory subCategory, String name, int price,
                UnitOfMeasurement unitOfMeasurement, DiscountStrategy discountStrategy) {
        this.category = category;
        this.subCategory = subCategory;
        this.name = name;
        this.price = price;
        this.unitOfMeasurement = unitOfMeasurement;
        this.itemDiscount = discountStrategy;
    }

    public int calculateTotalPrice(int quantity) {
        return quantity * price;
    }

    public int calculateMaxEligibleDiscount(int quantity) {
        int categoryDiscountAmount = category.calculateDiscountAmount(quantity, price);
        int subCategoryDiscountAmount = subCategory.calculateDiscountAmount(quantity, price);
        int itemDiscountAmount = itemDiscount.calculateDiscountAmount(quantity, price);

        int maxOfItemAndSubCategoryDiscountAmount = max(subCategoryDiscountAmount, itemDiscountAmount);

        return max(categoryDiscountAmount, maxOfItemAndSubCategoryDiscountAmount);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}