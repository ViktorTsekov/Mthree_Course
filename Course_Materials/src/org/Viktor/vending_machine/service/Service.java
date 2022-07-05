package org.Viktor.vending_machine.service;

import org.Viktor.vending_machine.dao.ConnectToDb;
import org.Viktor.vending_machine.dto.Item;
import org.Viktor.vending_machine.exceptions.InsufficientFunds;
import org.Viktor.vending_machine.exceptions.OutOfBounds;
import org.Viktor.vending_machine.exceptions.UnavailableInventory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Service {
    private ConnectToDb connectToDb;

    public Service(ConnectToDb connectToDb) {
        this.connectToDb = connectToDb;
    }

    public enum Change {
        QUARTER,
        DIME,
        NICKEL,
        PENNIE;

        public static String getPrintable(Change change, int quantity) {
            return quantity + " " + change.toString().toLowerCase() + (quantity == 1 ? "" : "s");
        }
    }

    public String calculateChange(int changeInPennies) {
        if (changeInPennies < 0) throw new IllegalArgumentException();

        int temp = changeInPennies;

        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;

        while(temp > 0) {
            if(temp >= 25) {
                temp -= 25;
                quarters++;
            } else if(temp >= 10) {
                temp -= 10;
                dimes++;
            } else if(temp >= 5) {
                temp -= 5;
                nickels++;
            } else {
                temp -= 1;
                pennies++;
            }
        }

        return Change.getPrintable(Change.QUARTER, quarters) + ", "
                + Change.getPrintable(Change.DIME, dimes) + ", "
                + Change.getPrintable(Change.NICKEL, nickels) + ", "
                + Change.getPrintable(Change.PENNIE, pennies);
    }

    public String getInformationAboutItems() {
        ArrayList<Item> contents = connectToDb.getContentsFromFile();
        StringBuilder str = new StringBuilder();

        IntStream.range(0, contents.size()).forEach(index -> {
            Item cur = contents.get(index);
            str.append((index + 1) + ". " + cur.getItemName() + "\n" + "Price: " + cur.getPrice() + "\n" + "Inventory: " + cur.getInventory() + "\n");
        });

        return str.toString();
    }

    public double buyItem(int itemId, double insertedMoney) throws OutOfBounds, InsufficientFunds, UnavailableInventory {
        ArrayList<Item> items = connectToDb.getContentsFromFile();

        if(itemId > items.size() || itemId < 1) {
            throw new OutOfBounds();
        }

        Item item = items.get(itemId - 1);

        if(item.getPrice() > insertedMoney) {
            throw new InsufficientFunds();
        } else if(item.getInventory() == 0) {
            throw new UnavailableInventory();
        } else {
            item.setInventory(item.getInventory() - 1);
            items.set(itemId - 1, item);
            connectToDb.overrideFile(items);

            return Service.round(insertedMoney - item.getPrice(), 2);
        }
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
