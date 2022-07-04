package org.Viktor.vending_machine.dto;

public class Item {
    private String itemName;
    private double price;
    private int inventory;

    public Item(String itemName, double price, int inventory) {
        this.itemName = itemName;
        this.price = price;
        this.inventory = inventory;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
