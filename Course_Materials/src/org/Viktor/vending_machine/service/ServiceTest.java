package org.Viktor.vending_machine.service;

import org.Viktor.vending_machine.dto.Item;
import org.Viktor.vending_machine.injector.Injector;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {
    @Test
    public void testingTheCalculateChangeMethod() {
        var service = new Injector().makeService();

        assertEquals("6 quarters, 2 dimes, 0 nickels, 0 pennies", service.calculateChange(170));
        assertEquals("11 quarters, 2 dimes, 0 nickels, 4 pennies", service.calculateChange(299));
        assertEquals("0 quarters, 0 dimes, 0 nickels, 1 pennie", service.calculateChange(1));
        assertEquals("2 quarters, 0 dimes, 0 nickels, 0 pennies", service.calculateChange(50));
        assertEquals("1 quarter, 2 dimes, 0 nickels, 4 pennies", service.calculateChange(49));
        assertEquals("0 quarters, 0 dimes, 0 nickels, 0 pennies", service.calculateChange(0));
        assertEquals("2 quarters, 1 dime, 1 nickel, 4 pennies", service.calculateChange(69));
        assertEquals("16 quarters, 2 dimes, 0 nickels, 0 pennies", service.calculateChange(420));
    }

    @Test
    public void testingTheRoundMethod() {
        var service = new Injector().makeService();

        assertEquals(3.14, service.round(3.1436, 2));
        assertEquals(10, service.round(9.9999, 3));
        assertEquals(9, service.round(9.4999, 0));
    }

    @Test
    public void testingTheGetInformationAboutItemsMethod() {
        var service = new Injector().makeService();
        var connectToDb = new Injector().makeDbConnection();
        int numberOfItems = service.getInformationAboutItems().split("\n").length / 3;

        assertEquals(numberOfItems, connectToDb.getContentsFromFile().size());
    }

    @Test
    public void testingTheBuyItemMethod() {
        var service = new Injector().makeService();
        var connectToDb = new Injector().makeDbConnection();
        int inventoryBeforeBuying = connectToDb.getContentsFromFile().get(0).getInventory();
        double insertedMoney = 10;
        double change = 0;

        if(inventoryBeforeBuying != 0) {
            try {
                change = service.buyItem(1, insertedMoney);
            } catch (Exception e) { }

            // Checking if the item is removed from inventory
            assertEquals(inventoryBeforeBuying - 1, connectToDb.getContentsFromFile().get(0).getInventory());
            // Checking if the correct change is returned
            assertEquals(insertedMoney - connectToDb.getContentsFromFile().get(0).getPrice(), change);
        }
    }
}