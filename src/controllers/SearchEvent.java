package controllers;

import models.EventData;
import models.Events;
import views.ListMenu;
import java.util.Scanner;

public class SearchEvent {

    private final Events EventModel;
    public SearchEvent(Events eventModel) {
        EventModel = eventModel;
    }
    public void UserSearchEventByLocation () {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter location to find event: ");
        String location = sc.nextLine();
        int count = 0;
        System.out.println(ListMenu.displayOfHeader());
        for (EventData eventData : EventModel.getEvents()){
            if (eventData.getLocation().contains(location)){
                count++;
                System.out.println(eventData.displayOfEvent());
            }
        }
        if (count == 0) System.out.println("No Event Found");
        System.out.println("\nContinue searching another event ?");
        int choice = ListMenu.continueFeature();
        if (choice == 1){
            UserSearchEventByLocation();
        }
    }
}
