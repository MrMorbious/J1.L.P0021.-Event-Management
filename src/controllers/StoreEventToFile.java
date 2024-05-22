package controllers;

import models.EventData;
import models.Events;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class StoreEventToFile {
    private final Events EventModel;
    public StoreEventToFile(Events eventModel) {
        EventModel = eventModel;
    }
    public void storeDataToFile(){
        EventModel.storeDataToFile();
        System.out.println("Store data to file success!");
    }
}
