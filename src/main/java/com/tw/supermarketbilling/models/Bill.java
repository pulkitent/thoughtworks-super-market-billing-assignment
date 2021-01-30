package com.tw.supermarketbilling.models;

import com.tw.supermarketbilling.parser.Printer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bill {
    private final int id;
    private final Map<ShoppingBucket, Integer> shoppingBucketAndPriceMap;
    private int totalSavings;
    private int billAmountAfterDiscount;
    private int billAmountBeforeDiscount;
    private Printer printer;

    public Bill(int id, Printer printer) {
        this.id = id;
        this.shoppingBucketAndPriceMap = new HashMap<>();
        this.printer = printer;
    }

    public void generate(List<ShoppingBucket> shoppingBucketList) {
        for (ShoppingBucket bucket : shoppingBucketList) {
            Item item = bucket.getItem();
            int quantity = bucket.getQuantity();

            int priceOfItem = item.calculateTotalPrice(quantity);
            billAmountBeforeDiscount = billAmountBeforeDiscount + priceOfItem;

            int maxDiscount = item.calculateMaxEligibleDiscount(quantity);
            int priceOfItemAfterDiscount = priceOfItem - maxDiscount;
            billAmountAfterDiscount = billAmountAfterDiscount + priceOfItemAfterDiscount;
            totalSavings = totalSavings + maxDiscount;

            shoppingBucketAndPriceMap.put(bucket, priceOfItemAfterDiscount);
        }
    }

    public void print(Customer customer) {
        printer.printBill(billAmountAfterDiscount, billAmountBeforeDiscount, shoppingBucketAndPriceMap, customer);
    }
}