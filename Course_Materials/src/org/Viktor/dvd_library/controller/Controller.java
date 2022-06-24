package org.Viktor.dvd_library.controller;

import org.Viktor.dvd_library.database.ConnectToDb;
import org.Viktor.dvd_library.logic.Helper;
import org.Viktor.dvd_library.dependency_injector.Injector;

import java.util.ArrayList;

public class Controller {
    private Helper helper;
    private ConnectToDb dbConnection;

    public Controller(Injector inj) {
        helper = inj.makeHelper();
        dbConnection = inj.makeDbConnection();
    }

    public void addNewDvd(String userInput) {
        StringBuilder str = new StringBuilder();
        ArrayList<String> contents = dbConnection.getContentsFromFile();

        contents.add(userInput);
        dbConnection.overrideFile(contents);
    }

    public String listAllDvds() {
        ArrayList<String> contents = dbConnection.getContentsFromFile();
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < contents.size(); i++) {
            str.append((i + 1) + ". " + contents.get(i) + (i != contents.size() - 1 ? "\n" : ""));
        }

        return str.toString();
    }

    public void deleteDvd(int dvdIndex) {
        ArrayList<String> contents = dbConnection.getContentsFromFile();

        contents.remove(dvdIndex - 1);
        dbConnection.overrideFile(contents);
    }

    public String getSingleDvd(String key) {
        ArrayList<String> contents = dbConnection.getContentsFromFile();
        String dvd = "";

        if(helper.isNumeric(key)) {
            dvd = contents.get(Integer.parseInt(key) - 1);
        } else {
            for(int i = 0; i < contents.size(); i++) {
                String cur = contents.get(i);
                String[] strings = cur.replaceAll("\\s+", "").split(",");

                if(strings[0].equals(key.replaceAll("\\s+", ""))) {
                    dvd = cur;
                    break;
                }
            }
        }

        return dvd;
    }

    public void editDvd(int dvdIndex, String userInput) {
        ArrayList<String> contents = dbConnection.getContentsFromFile();

        contents.set(dvdIndex - 1, userInput);
        dbConnection.overrideFile(contents);
    }
}
