package com.tw.supermarketbilling.models;

public interface DiscountStrategy {
    int calculateDiscountAmount(int quantity, int pricePerUnit);
}