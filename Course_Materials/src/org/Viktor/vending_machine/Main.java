package org.Viktor.vending_machine;

import org.Viktor.vending_machine.injector.Injector;

public class Main {
    public static void main(String[] args) {
        new Injector().makeView().run();
    }
}
