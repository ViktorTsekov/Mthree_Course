package org.Viktor.vending_machine.injector;

import org.Viktor.vending_machine.service.Service;
import org.Viktor.vending_machine.controller.Controller;
import org.Viktor.vending_machine.dao.ConnectToDb;
import org.Viktor.vending_machine.view.View;

import java.util.Scanner;

public interface PackageManager {
    Controller makeController();
    ConnectToDb makeDbConnection();
    Service makeService();

    Scanner makeScanner();
    View makeView();
}