package com.tw.supermarketbilling.parser;

import com.tw.supermarketbilling.models.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ConsoleInputParser implements InputParser {
    private static final String ALPHA_NUMERIC_WORDS_REGEX = "\\W+";
    private static final String NON_DIGIT_CHARACTER_REGEX = "[\\D]";
    private static final String EMPTY_STRING = "";

    @Override
    public void createBill(String input, Inventory inventory) {
        Customer customer = createCustomer(input);
        String[] parsedInput = input.split(ALPHA_NUMERIC_WORDS_REGEX);

        List<ShoppingBucket> shoppingBucketList = new ArrayList<>();
        createShoppingBucketList(inventory, parsedInput, shoppingBucketList);

        Printer printer = new ConsoleOutputPrinter();
        Bill bill = new Bill(123, printer);
        bill.generate(shoppingBucketList);
        bill.print(customer);
    }

    @Override
    public Order createOrder(String input, Inventory inventory) {
        Customer customer = createCustomer(input);
        String[] parsedInput = input.split(ALPHA_NUMERIC_WORDS_REGEX);

        List<ShoppingBucket> shoppingBucketList = new ArrayList<>();
        createShoppingBucketList(inventory, parsedInput, shoppingBucketList);

        return new Order(shoppingBucketList, customer);
    }

    private static Customer createCustomer(String input) {
        String[] parsedInput = input.split(ALPHA_NUMERIC_WORDS_REGEX);
        String firstName = parsedInput[1];
        String lastName = parsedInput[2];
        Customer customer = new Customer(firstName, lastName);

        return customer;
    }

    private void createShoppingBucketList(Inventory inventory, String[] parsedInput, List<ShoppingBucket> shoppingBucketList) {
        for (int index = 6; index < parsedInput.length; index += 2) {
            int quantity = parseInt(parsedInput[index + 1].replaceAll(NON_DIGIT_CHARACTER_REGEX, EMPTY_STRING));
            Item item = inventory.getItemByName(parsedInput[index]);
            ShoppingBucket shoppingBucket = new ShoppingBucket(item, quantity);

            shoppingBucketList.add(shoppingBucket);
        }
    }
}