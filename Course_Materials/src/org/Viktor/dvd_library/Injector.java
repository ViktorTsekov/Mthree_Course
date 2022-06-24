package org.Viktor.dvd_library;

import java.util.Scanner;

public class Injector implements DependencyManager {

    @Override
    public Helper makeHelper() {
        return new Helper();
    }

    @Override
    public Scanner makeScanner() { return new Scanner(System.in); }

    @Override
    public Controller makeController() { return new Controller(new Injector()); }

    @Override
    public ConnectToDb makeDbConnection() {
        return new ConnectToDb();
    }

    @Override
    public Interface makeInterface() {
        return new Interface(new Injector());
    }
}
