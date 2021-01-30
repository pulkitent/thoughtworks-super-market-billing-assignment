package com.tw.supermarketbilling.parser;

import com.tw.supermarketbilling.models.Inventory;
import com.tw.supermarketbilling.models.Order;

public interface InputParser {
    void createBill(String input, Inventory inventory);

    Order createOrder(String input, Inventory inventory);
}