package com.tw.supermarketbilling.models;

import static com.tw.supermarketbilling.constants.Constants.*;

public class Customer {
    private final String firstName;
    private final String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + SPACE_DELIMITER + lastName;
    }
}
