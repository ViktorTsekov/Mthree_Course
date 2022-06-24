package org.Viktor.dvd_library.dependency_injector;

import org.Viktor.dvd_library.controller.Controller;
import org.Viktor.dvd_library.database.ConnectToDb;
import org.Viktor.dvd_library.logic.Helper;
import org.Viktor.dvd_library.view.Interface;

import java.util.Scanner;

public interface DependencyManager {
    public Helper makeHelper();
    public Scanner makeScanner();
    public Controller makeController();
    public ConnectToDb makeDbConnection();
    public Interface makeInterface();
}
