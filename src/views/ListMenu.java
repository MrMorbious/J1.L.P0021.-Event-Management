package views;

import java.util.Scanner;

public class ListMenu {
    public ListMenu() {
    }
    public static int inputMenu(){
        System.out.print("Your choice is: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int choice;
        if (input.isEmpty()) {
            System.out.println("Your choice cannot empty . Please enter your choice again !");
            inputMenu();
        }
        try {
            choice = Integer.parseInt(input);
            if(choice <= 0 || choice > 7){
                System.out.println("Please enter function from 1 to 7!");
                return inputMenu();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input number. Please enter your choice again !");
            return inputMenu();
        }

        return choice;
    }
    public static void getWelcome() {
        System.out.println("\n");
        System.out.println("============Welcome to Event Manager============");
        System.out.println("1. Create a new event");
        System.out.println("2. Check if an event exists");
        System.out.println("3. Search for event information by location");
        System.out.println("4. Update or delete event");
        System.out.println("\t4.1. Update event details");
        System.out.println("\t4.2. Delete event");
        System.out.println("5. Save events to a file");
        System.out.println("6. Print the list of events from the file");
        System.out.println("7. Quit");
        System.out.println("=================================================");
    }
    public static int continueFeature(){
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("\nYour choice: ");
        Scanner sc = new Scanner(System.in);
        String input_choice = sc.nextLine();
        int choice;
        if (input_choice.isEmpty()){
            System.out.println("Just choice 1 or 2!");
            return continueFeature();
        }
        try {
            choice = Integer.parseInt(input_choice);
            if(choice != 1 && choice != 2){
                System.out.println("Just choice 1 or 2!");
                return continueFeature();
            }
        }catch (NumberFormatException e) {
            System.out.println("Just choice 1 or 2!");
            return continueFeature();
        }
        return choice;
    }
    public static int MenuUpdate(){
        System.out.println("1. Update event details");
        System.out.println("2. Delete event");
        System.out.print("\nYour choice: ");
        Scanner sc = new Scanner(System.in);
        int choice;
        String input = sc.nextLine();
        if (input.isEmpty()) {
            System.out.println("\nCannot empty!");
            System.out.println("Just choice 1 or 2!\n");
            return MenuUpdate();
        }
        try {
            choice = Integer.parseInt(input);
            if(choice != 1 && choice != 2){
                System.out.println("\nJust choice 1 or 2!\n");
                return MenuUpdate();
            }
        } catch (NumberFormatException e) {
            System.out.println("\nJust choice 1 or 2!\n");
            return MenuUpdate();
        }
        return choice;
    }
    public static int MenuDisplay(){
        System.out.println("1. Display by sorted");
        System.out.println("2. Display by normal");
        System.out.print("\nYour choice: ");
        Scanner sc = new Scanner(System.in);
        int choice;
        String input = sc.nextLine();
        if (input.isEmpty()) {
            System.out.println("\nCannot empty!");
            System.out.println("Just choice 1 or 2!\n");
            return MenuUpdate();
        }
        try {
            choice = Integer.parseInt(input);
            if(choice != 1 && choice != 2){
                System.out.println("\nJust choice 1 or 2!\n");
                return MenuUpdate();
            }
        } catch (NumberFormatException e) {
            System.out.println("\nJust choice 1 or 2!\n");
            return MenuUpdate();
        }
        return choice;
    }
    public static String displayOfHeader () {
        return String.format(
                "----------------------------------------------------------------------------------------------\n" +
                        "| %-10s | %-15s | %-10s | %-15s | %-10s | %-15s |\n" +
                        "----------------------------------------------------------------------------------------------",
                "Event ID", "Name", "Date", "Location", "Attendees", "Status"
        );
    }

}
