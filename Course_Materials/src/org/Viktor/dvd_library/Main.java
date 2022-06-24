package org.Viktor.dvd_library;

public class Main {
    public static void main(String[] args) {
        try {
            new Injector().makeInterface().startApplication();
        } catch (Exception e) {
            System.out.println("Unexpected error has occurred!");
        }
    }
}
