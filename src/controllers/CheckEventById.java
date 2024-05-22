package controllers;

import controllers.validators.EventUpdateValidator;
import models.Events;
import views.ListMenu;

public class CheckEventById extends EventUpdateValidator {
    private final Events EventModel;
    public CheckEventById(Events eventModel) {
        EventModel = eventModel;
    }
    public void UserCheckEventById () {
        int idEvent = validateID();
        if (EventModel.getIndexById(idEvent) == -1)
            System.out.println("\n--> No Event Found! <--");
         else System.out.println("\n--> Exist Event <--");
        System.out.println("\nContinue checking another event ?");
        int choice = ListMenu.continueFeature();
        if (choice == 1) {
            UserCheckEventById();
        }
    }
}
