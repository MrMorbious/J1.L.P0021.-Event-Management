package controllers;

import controllers.validators.EventUpdateValidator;
import models.EventData;
import models.Events;
import views.ListMenu;

import java.time.LocalDate;

public class UpdateEventCreate extends EventUpdateValidator {

    private final Events EventModel;

    public UpdateEventCreate(Events eventModel) {
        EventModel = eventModel;
    }

    public void UserUpdateEvent(){
        int idEvent = validateID();
        if (EventModel.getIndexById(idEvent) == -1){
            System.out.println("ID event is not exist.");
            UserUpdateEvent();
            return;
        }
        System.out.println("\n---> Leave blank to keep current <---");
        EventData eventData = EventModel.getEventById(idEvent);

        String name = validateName(eventData.getName());
        eventData.setName(name);

        LocalDate date = validateDate(eventData.getDate());
        eventData.setDate(date);

        String location = validateLocation(eventData.getLocation());
        eventData.setLocation(location);

         int attendees = validateAttendees(eventData.getNumberOfAttendees());
         eventData.setNumberOfAttendees(attendees);

         boolean status = validateStatus(eventData.isStatus());
         eventData.setStatus(status);

        EventModel.updateEvent(idEvent, eventData);

        System.out.println("\nUpdate success !");
        System.out.println("Continue updating another event ?");
        int choice = ListMenu.continueFeature();
        if (choice == 1){
            UserUpdateEvent();
        }

    }
    public void UserDeleteEvent(){
        int idEvent = validateID();
        if (EventModel.getIndexById(idEvent) == -1){
            System.out.println("ID event is not exist.");
            System.out.println("Continue deleting another event ?");
            int choice = ListMenu.continueFeature();
            if (choice == 1) {
                UserUpdateEvent();
            }
            return;
        }
        System.out.println("Are you sure delete this event id ?");
        int choice = ListMenu.continueFeature();
        if (choice == 1) {
            EventModel.deleteEvents(idEvent);
            System.out.println("\nDelete success !");
        }
        System.out.println("Continue deleting another event ?");
        choice = ListMenu.continueFeature();
        if (choice == 1) {
            UserDeleteEvent();
        }
    }

}
