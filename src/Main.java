import controllers.*;
import models.Events;
import views.ListMenu;

public class Main {
    public static Events eventModel = new Events();
    public static CreateEventCreate createEvent = new CreateEventCreate(eventModel);
    public static UpdateEventCreate updateEvent = new UpdateEventCreate(eventModel);
    public static DisplayEvent displayEvent = new DisplayEvent(eventModel);
    public static StoreEventToFile storeEventToFile = new StoreEventToFile(eventModel);
    public static CheckEventById checkEventById = new CheckEventById(eventModel);
    public static SearchEvent searchEvent = new SearchEvent(eventModel);

    public static void main(String[] args) {
        eventModel.loadDataFromFile();
        program();
    }
    public static void program (){
        while(true){
            ListMenu.getWelcome();
            int choice = ListMenu.inputMenu();
            switch (choice) {
                case 1:
                    createEvent.UserCreateEvent();
                    break;
                case 2:
                    checkEventById.UserCheckEventById();
                    break;
                case 3:
                    searchEvent.UserSearchEventByLocation();
                    break;
                case 4:
                    int choiceUpdate = ListMenu.MenuUpdate();
                    if (choiceUpdate == 1){
                        updateEvent.UserUpdateEvent();
                    }
                    if (choiceUpdate == 2){
                        updateEvent.UserDeleteEvent();
                    }
                    break;
                case 5:
                    storeEventToFile.storeDataToFile();
                    break;
                case 6:
                    int choiceDisplay = ListMenu.MenuDisplay();
                    if (choiceDisplay == 1 ) {
                        displayEvent.UserDisplaySortEvent();
                    }
                    if (choiceDisplay == 2) {
                        displayEvent.UserDisplayEvent();
                    }
                    break;
                case 7:
                    System.out.println("Quit menu. See you later!");
                    return;
            }
        }
    }

}