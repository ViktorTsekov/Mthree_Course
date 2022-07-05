package org.Viktor.vending_machine.dao;

import org.Viktor.vending_machine.dto.Item;
import org.Viktor.vending_machine.injector.Injector;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ConnectToDbTest {
    @Test
    public void testingMarshallingAndUnmarshallingDataFromFile() {
        var connectToDb = new Injector().makeDbConnection();
        ArrayList<Item> oldItems = connectToDb.getContentsFromFile();
        ArrayList<Item> newItems = new ArrayList<>();

        newItems.add(new Item("itemA", 0, 0));

        connectToDb.overrideFile(newItems);
        // Checking if we have overridden the file successfully
        assertEquals("itemA", connectToDb.getContentsFromFile().get(0).getItemName());

        connectToDb.overrideFile(oldItems);
        // Checking if we have restored the previous contents of the file
        assertEquals(oldItems.get(0).getItemName(), connectToDb.getContentsFromFile().get(0).getItemName());
    }
}