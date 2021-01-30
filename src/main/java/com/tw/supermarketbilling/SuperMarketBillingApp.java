package com.tw.supermarketbilling;

import com.tw.supermarketbilling.models.*;
import com.tw.supermarketbilling.parser.ConsoleInputParser;
import com.tw.supermarketbilling.parser.InputParser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static com.tw.supermarketbilling.constants.Constants.*;
import static com.tw.supermarketbilling.constants.UnitOfMeasurement.*;

public class SuperMarketBillingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Order Input");
        String orderInput = scanner.nextLine();

        SuperMarketBillingApp superMarketBillingApp = new SuperMarketBillingApp();
        List<Item> itemList = superMarketBillingApp.getItemList();
        Inventory inventory = new Inventory(itemList);

        InputParser consoleInputParser = new ConsoleInputParser();
        consoleInputParser.createOrder(orderInput, inventory);
        consoleInputParser.createBill(orderInput, inventory);
    }

    private List<Item> getItemList() {
        List<DiscountStrategy> flatDiscountList = getFlatDiscountList();
        List<Category> categoryList = getCategoryList(flatDiscountList);
        List<SubCategory> subCategoryList = getSubCategoryList(flatDiscountList);
        List<DiscountStrategy> freeItemDiscountList = getFreeItemDiscountList();

        Category fruitsAndVegetableCategory = categoryList.get(0);

        SubCategory fruitsSubCategory = subCategoryList.get(0);
        DiscountStrategy appleDiscountStrategy = freeItemDiscountList.get(0);

        Item apple = new Item(fruitsAndVegetableCategory, fruitsSubCategory, APPLE, 50, WEIGHT, appleDiscountStrategy);
        DiscountStrategy orangeDiscountStrategy = flatDiscountList.get(7);
        Item orange = new Item(fruitsAndVegetableCategory, fruitsSubCategory, ORANGE, 80, WEIGHT, orangeDiscountStrategy);

        SubCategory vegetablesSubCategory = subCategoryList.get(0);
        DiscountStrategy potatoDiscountStrategy = freeItemDiscountList.get(1);
        Item potato = new Item(fruitsAndVegetableCategory, vegetablesSubCategory, POTATO, 30, WEIGHT, potatoDiscountStrategy);
        DiscountStrategy tomatoDiscountStrategy = flatDiscountList.get(8);
        Item tomato = new Item(fruitsAndVegetableCategory, vegetablesSubCategory, TOMATO, 70, WEIGHT, tomatoDiscountStrategy);

        Category dairyCategory = categoryList.get(1);

        SubCategory milkSubCategory = subCategoryList.get(0);
        DiscountStrategy cowMilkDiscountStrategy = freeItemDiscountList.get(2);
        Item cowMilk = new Item(dairyCategory, milkSubCategory, COW_MILK, 50, VOLUME, cowMilkDiscountStrategy);
        DiscountStrategy soyMilkDiscountStrategy = flatDiscountList.get(9);
        Item soyMilk = new Item(dairyCategory, milkSubCategory, SOY_MILK, 40, VOLUME, soyMilkDiscountStrategy);

        SubCategory cheeseSubCategory = subCategoryList.get(0);
        DiscountStrategy cheddarDiscountStrategy = freeItemDiscountList.get(3);
        Item cheddar = new Item(dairyCategory, cheeseSubCategory, CHEDDAR, 50, WEIGHT, cheddarDiscountStrategy);
        DiscountStrategy goudaDiscountStrategy = flatDiscountList.get(7);
        Item gouda = new Item(dairyCategory, cheeseSubCategory, GOUDA, 80, WEIGHT, goudaDiscountStrategy);

        List<Item> inventoryList = new ArrayList<>();

        inventoryList.add(apple);
        inventoryList.add(orange);
        inventoryList.add(potato);
        inventoryList.add(tomato);
        inventoryList.add(cowMilk);
        inventoryList.add(soyMilk);
        inventoryList.add(cheddar);
        inventoryList.add(gouda);

        return inventoryList;
    }

    private List<DiscountStrategy> getFreeItemDiscountList() {
        DiscountStrategy appleDiscountStrategy = new FreeItemDiscount(3, 1);
        DiscountStrategy potatoDiscountStrategy = new FreeItemDiscount(5, 2);
        DiscountStrategy cowMilkDiscountStrategy = new FreeItemDiscount(3, 1);
        DiscountStrategy cheddarDiscountStrategy = new FreeItemDiscount(2, 1);

        List<DiscountStrategy> discountStrategyList = new LinkedList<>();
        discountStrategyList.add(appleDiscountStrategy);
        discountStrategyList.add(potatoDiscountStrategy);
        discountStrategyList.add(cowMilkDiscountStrategy);
        discountStrategyList.add(cheddarDiscountStrategy);

        return discountStrategyList;
    }

    private List<SubCategory> getSubCategoryList(List<DiscountStrategy> flatDiscountList) {
        SubCategory fruitSubCategory = new SubCategory(FRUITS, flatDiscountList.get(1));
        SubCategory vegetableSubCategory = new SubCategory(VEGETABLES, flatDiscountList.get(2));
        SubCategory milkSubCategory = new SubCategory(MILK, flatDiscountList.get(4));
        SubCategory cheeseSubCategory = new SubCategory(CHEESE, flatDiscountList.get(5));

        List<SubCategory> subCategoryList = new LinkedList<>();
        subCategoryList.add(fruitSubCategory);
        subCategoryList.add(vegetableSubCategory);
        subCategoryList.add(milkSubCategory);
        subCategoryList.add(cheeseSubCategory);

        return subCategoryList;
    }

    private List<DiscountStrategy> getFlatDiscountList() {
        DiscountStrategy produceDiscountStrategy = new FlatDiscount(20);
        DiscountStrategy fruitsDiscountStrategy = new FlatDiscount(18);
        DiscountStrategy vegDiscountStrategy = new FlatDiscount(5);
        DiscountStrategy dairyDiscountStrategy = new FlatDiscount(15);
        DiscountStrategy milkDiscountStrategy = new FlatDiscount(20);
        DiscountStrategy cheeseDiscountStrategy = new FlatDiscount(20);
        DiscountStrategy goudaDiscountStrategy = new FlatDiscount(10);
        DiscountStrategy orangeDiscountStrategy = new FlatDiscount(20);
        DiscountStrategy tomatoDiscountStrategy = new FlatDiscount(10);
        DiscountStrategy soyMilkDiscountStrategy = new FlatDiscount(10);

        List<DiscountStrategy> flatDiscountList = new LinkedList<>();
        flatDiscountList.add(produceDiscountStrategy);
        flatDiscountList.add(fruitsDiscountStrategy);
        flatDiscountList.add(vegDiscountStrategy);
        flatDiscountList.add(dairyDiscountStrategy);
        flatDiscountList.add(milkDiscountStrategy);
        flatDiscountList.add(cheeseDiscountStrategy);
        flatDiscountList.add(goudaDiscountStrategy);
        flatDiscountList.add(orangeDiscountStrategy);
        flatDiscountList.add(tomatoDiscountStrategy);
        flatDiscountList.add(soyMilkDiscountStrategy);

        return flatDiscountList;
    }

    private List<Category> getCategoryList(List<DiscountStrategy> flatDiscountList) {
        DiscountStrategy produceDiscountStrategy = flatDiscountList.get(0);
        Category fruitsAndVegetableCategory = new Category(PRODUCE, produceDiscountStrategy);

        DiscountStrategy dairyDiscountStrategy = flatDiscountList.get(3);
        Category dairyCategory = new Category(DAIRY, dairyDiscountStrategy);

        List<Category> categoryList = new LinkedList<>();
        categoryList.add(fruitsAndVegetableCategory);
        categoryList.add(dairyCategory);

        return categoryList;
    }
}