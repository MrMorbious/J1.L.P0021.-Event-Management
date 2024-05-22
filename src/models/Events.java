package models;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Events {
    private ArrayList<EventData> listOfEvents = new ArrayList<>();
    private int autoIncrementID(){
        if (listOfEvents != null && !listOfEvents.isEmpty()) {
            return listOfEvents.get(listOfEvents.size() - 1).getEventId()+1;
        }
        return 1;
    }
    public int getIndexById(int idEvent){
        int index = 0;
        for (EventData events : listOfEvents){
            if (events.getEventId() == idEvent){
                return index;
            }
            index++;
        }
        return -1;
    }
    public EventData getEventById(int idEvent){
        for (EventData events : listOfEvents){
            if (events.getEventId() == idEvent){
                return events;
            }
        }
        return null;
    }
    public ArrayList<EventData> getEvents (){
        return new ArrayList<EventData>(listOfEvents);
    }
    public boolean addEvents(EventData events){
        try {
            events.setEventId(autoIncrementID());
            listOfEvents.add(events);
        } catch (Exception e){
            return false;
        }
        return true;
    }
    public boolean updateEvent(int idEvent, EventData event){
        try {
            listOfEvents.set(getIndexById(idEvent), event);
        } catch (Exception e){
            return false;
        }
        return true;
    }
    public boolean deleteEvents(int idEvent){
        try {
            listOfEvents.remove(getIndexById(idEvent));
        } catch (Exception e){
            return false;
        }
        return true;
    }
    public void loadDataFromFile(){
        String fileNameOfEvent = "events.dat";
        try {
            File f = new File(fileNameOfEvent);
            if (!f.exists()) return;
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream fo = new ObjectInputStream(fi);
            EventData event;
            while((event = (EventData)fo.readObject()) != null) {
                listOfEvents.add(event);
            }
            fo.close();
            fi.close();
        }catch (Exception ignored){

        }
    }
    public void storeDataToFile(){
        String fileNameOfEvent = "events.dat";
        try{
            FileOutputStream f = new FileOutputStream(fileNameOfEvent);
            ObjectOutputStream fo = new ObjectOutputStream(f);
            for (EventData event : listOfEvents){
                fo.writeObject(event);
            }
            fo.close();
            f.close();
        }catch (Exception ignored){
        }
    }

}
