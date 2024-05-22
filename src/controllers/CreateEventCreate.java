package controllers;

import controllers.validators.EventCreateValidator;
import models.EventData;
import models.Events;
import views.ListMenu;

import java.time.LocalDate;

public class CreateEventCreate extends EventCreateValidator {
    private final Events EventModel;

    public CreateEventCreate(Events eventModel) {
        EventModel = eventModel;
    }

    public void UserCreateEvent(){
        EventData eventData = new EventData();

        String name = validateName();
        eventData.setName(name);

        LocalDate date = validateDate();
        eventData.setDate(date);

        String location = validateLocation();
        eventData.setLocation(location);

        int attendees = validateAttendees();
        eventData.setNumberOfAttendees(attendees);

        boolean status = validateStatus();
        eventData.setStatus(status);

        EventModel.addEvents(eventData);

        System.out.println("\nAdded success !");
        System.out.println("Continue adding another event ?");
        if (ListMenu.continueFeature() == 1){
            UserCreateEvent();
        }

    }

}
