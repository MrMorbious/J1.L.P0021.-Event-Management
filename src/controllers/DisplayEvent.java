package controllers;

import models.EventData;
import models.Events;
import views.ListMenu;

import java.util.ArrayList;
import java.util.Comparator;

public class DisplayEvent {
    private final Events EventModel;

    public DisplayEvent(Events eventModel) {
        EventModel = eventModel;
    }
    public void UserDisplayEvent() {
        System.out.println(ListMenu.displayOfHeader());
        for (EventData eventData : EventModel.getEvents()){
            System.out.println(eventData.displayOfEvent());
        }
    }
    public void UserDisplaySortEvent() {
        System.out.println(ListMenu.displayOfHeader());
        ArrayList<EventData> listOfEvents = EventModel.getEvents();
        listOfEvents.sort(new EventDateComparators());
        for (EventData event : listOfEvents) {
            System.out.println(event.displayOfEvent());
        }
    }

}

class EventDateComparators implements Comparator<EventData> {
    @Override
    public int compare(EventData e1, EventData e2) {
        int dateComparison = e1.getDate().compareTo(e2.getDate());
        if (dateComparison == 0) {
            return e1.getName().compareTo(e2.getName());
        }
        return dateComparison;
    }
}

