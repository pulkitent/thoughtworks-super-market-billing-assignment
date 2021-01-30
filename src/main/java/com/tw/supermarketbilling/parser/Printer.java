package com.tw.supermarketbilling.parser;

import com.tw.supermarketbilling.models.Customer;
import com.tw.supermarketbilling.models.ShoppingBucket;

import java.util.Map;

public interface Printer {
    void printBill(int billAmountAfterDiscount, int billAmountBeforeDiscount, Map<ShoppingBucket, Integer> shoppingBucketAndPriceMap, Customer customer);
}