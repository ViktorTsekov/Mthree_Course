package org.Viktor.vending_machine.dao;

import org.Viktor.vending_machine.dto.Item;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ConnectToDb {
    public static final String DELIMITER = "::";
    private static final String FILE_NAME = "Vending_Machine.txt";
    private static final String ERROR_MESSAGE = "An error has occurred: ";

    public void overrideFile(ArrayList<Item> contents) {
        StringBuilder str = new StringBuilder();

        contents.forEach((Item item) -> {
            str.append(item.getItemName() + DELIMITER + item.getPrice() + DELIMITER + item.getInventory() + "\n");
        });

        try {
            FileWriter myWriter = new FileWriter(FILE_NAME);

            myWriter.write(str.toString());
            myWriter.close();
        } catch (Exception e) {
            System.out.println(ERROR_MESSAGE + e);
        }
    }

    public ArrayList<Item> getContentsFromFile() {
        ArrayList<Item> contents = new ArrayList<>();

        try {
            File myObj = new File(FILE_NAME);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String[] lineSegments = myReader.nextLine().split(DELIMITER);

                contents.add(new Item(lineSegments[0], Double.parseDouble(lineSegments[1]), Integer.parseInt(lineSegments[2])));
            }

            myReader.close();
        } catch (Exception e) {
            System.out.println(ERROR_MESSAGE + e);
        }

        return contents;
    }
}
