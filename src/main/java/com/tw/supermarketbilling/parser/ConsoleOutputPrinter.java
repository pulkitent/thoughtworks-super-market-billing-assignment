package com.tw.supermarketbilling.parser;

import com.tw.supermarketbilling.models.Customer;
import com.tw.supermarketbilling.models.Item;
import com.tw.supermarketbilling.models.ShoppingBucket;

import java.util.Map;
import java.util.Set;

import static com.tw.supermarketbilling.constants.Constants.*;

public class ConsoleOutputPrinter implements Printer {
    @Override
    public void printBill(int billAmountAfterDiscount, int billAmountBeforeDiscount, Map<ShoppingBucket,
            Integer> shoppingBucketAndPriceMap, Customer customer) {
        System.out.println(BILL_HEADER_MESSAGE);
        System.out.println(CUSTOMER + customer.toString());
        System.out.printf(CONSOLE_FORMATTER, ITEM, QTY, AMOUNT);

        Set<Map.Entry<ShoppingBucket, Integer>> entries = shoppingBucketAndPriceMap.entrySet();

        for (Map.Entry<ShoppingBucket, Integer> entry : entries) {
            Item item = entry.getKey().getItem();
            int quantity = entry.getKey().getQuantity();
            Integer value = entry.getValue();

            System.out.printf(CONSOLE_FORMATTER, item, quantity, value);
        }

        System.out.println(LINE_SEPARATOR);
        System.out.printf(CONSOLE_FORMATTER, TOTAL_AMOUNT, billAmountAfterDiscount, RUPEE_SYMBOL);
        System.out.printf(CONSOLE_FORMATTER, YOU_SAVED, billAmountBeforeDiscount, DASH, billAmountAfterDiscount,
                EQUAL, RUPEE_SYMBOL);
    }
}