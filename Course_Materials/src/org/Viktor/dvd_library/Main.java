package org.Viktor.dvd_library;

import org.Viktor.dvd_library.dependency_injector.Injector;

public class Main {
    public static void main(String[] args) {
        try {
            new Injector().makeInterface().startApplication();
        } catch (Exception e) {
            System.out.println("\nUnexpected error has occurred!");
        }
    }
}
