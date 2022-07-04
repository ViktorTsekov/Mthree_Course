package org.Viktor.vending_machine.controller;

import org.Viktor.vending_machine.exceptions.OutOfBounds;
import org.Viktor.vending_machine.exceptions.UnavailableInventory;
import org.Viktor.vending_machine.exceptions.InsufficientFunds;
import org.Viktor.vending_machine.service.Service;

public class Controller {
    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public String fetchInformationAboutItems() {
        return service.getInformationAboutItems();
    }

    public double buyAnItem(int itemId, double insertedMoney) throws OutOfBounds, InsufficientFunds, UnavailableInventory {
        return service.buyItem(itemId, insertedMoney);
    }

    public String getChange(double change) {
        Double newChange = change * 100;
        return service.calculateChange(newChange.intValue());
    }
}
