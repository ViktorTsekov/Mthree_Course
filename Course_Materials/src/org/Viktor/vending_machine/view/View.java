package org.Viktor.vending_machine.view;

import org.Viktor.vending_machine.controller.Controller;
import org.Viktor.vending_machine.exceptions.OutOfBounds;
import org.Viktor.vending_machine.exceptions.UnavailableInventory;
import org.Viktor.vending_machine.exceptions.InsufficientFunds;

import java.util.Scanner;

public class View {
    Controller controller;
    Scanner scanner;

    public View(Controller controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void run() {
        int selectedItem;
        double insertedMoney;

        while(true) {
            System.out.println("\nAvailable Items:\n");
            System.out.println(controller.fetchInformationAboutItems());

            try {
                System.out.print("Insert an amount of money (for example 2.99): "); insertedMoney = Double.parseDouble(scanner.nextLine());
                System.out.print("Select an item (type -1 to exit): "); selectedItem = Integer.parseInt(scanner.nextLine());

                if(selectedItem < -1 || insertedMoney < 0) {
                    throw new OutOfBounds();
                }

                if(selectedItem == -1) {
                    System.out.println("\nThank you for using the application!");
                    break;
                } else {
                    try {
                        double change = controller.buyAnItem(selectedItem, insertedMoney);
                        System.out.println("\nItem purchased successfully, here is your change: " + controller.getChange(change));
                    } catch(OutOfBounds e) {
                        System.out.println("\nThe input provided is invalid.");
                    } catch (InsufficientFunds e) {
                        System.out.println("\nThe inserted amount of money " + insertedMoney + " is insufficient");
                    } catch (UnavailableInventory e) {
                        System.out.println("\nThe requested item is out of stock.");
                    }
                }
            } catch (Exception e) {
                System.out.println("\nAn error has occurred: " + e);
            }
        }
    }
}