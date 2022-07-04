package org.Viktor.vending_machine.injector;

import org.Viktor.vending_machine.controller.Controller;
import org.Viktor.vending_machine.dao.ConnectToDb;
import org.Viktor.vending_machine.service.Service;
import org.Viktor.vending_machine.view.View;

import java.util.Scanner;

public class Injector implements PackageManager {
    @Override
    public Controller makeController() {
        return new Controller(new Injector().makeService());
    }

    @Override
    public ConnectToDb makeDbConnection() {
        return new ConnectToDb();
    }

    @Override
    public Service makeService() {
        return new Service(new ConnectToDb());
    }

    @Override
    public Scanner makeScanner() {
        return new Scanner(System.in);
    }

    @Override
    public View makeView() {
        return new View(new Injector().makeController(), new Injector().makeScanner());
    }
}
