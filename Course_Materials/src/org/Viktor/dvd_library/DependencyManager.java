package org.Viktor.dvd_library;

import java.util.Scanner;

public interface DependencyManager {
    public Helper makeHelper();
    public Scanner makeScanner();
    public Controller makeController();
    public ConnectToDb makeDbConnection();
    public Interface makeInterface();
}
