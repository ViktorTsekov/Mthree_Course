package org.Viktor.dvd_library.database;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ConnectToDb {
    private static final String FILE_NAME = "DVD_Library.txt";
    private static final String ERROR = "An error occurred!";

    public void overrideFile(ArrayList<String> lines) {
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            if(!line.equals("")) {
                str.append(line + "\n");
            }
        }

        try {
            FileWriter myWriter = new FileWriter(FILE_NAME);

            myWriter.write(str.toString());
            myWriter.close();
        } catch (Exception e) {
            System.out.println(ERROR);
        }
    }

    public ArrayList<String> getContentsFromFile() {
        ArrayList<String> contents = new ArrayList<String>();

        try {
            File myObj = new File(FILE_NAME);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                if(!line.equals("")) {
                    contents.add(line);
                }
            }

            myReader.close();
        } catch (Exception e) {
            System.out.println(ERROR);
        }

        return contents;
    }
}
