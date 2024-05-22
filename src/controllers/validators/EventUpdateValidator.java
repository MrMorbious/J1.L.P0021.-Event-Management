package controllers.validators;

import models.EventData;

import java.time.LocalDate;
import java.util.Scanner;

public class EventUpdateValidator {
    protected int validateID(){
        int id;
        System.out.print("Enter id event: ");
        Scanner sc = new Scanner(System.in);
        String id_input = sc.nextLine();
        if (id_input.isEmpty()){
            System.out.println("Id cannot empty!");
            return validateID();
        }
        try {
            id = Integer.parseInt(id_input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid the number of attendees format!");
            return validateID();
        }
        return id;
    }
    protected String validateName(String defaultName){
        System.out.print("Enter event's name ("+defaultName+"): ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        if(name.isEmpty()) {
            return defaultName;
        }

        if (name.contains(" ")){
            System.out.println("The name not allow contain space characters. Please enter again.");
            return validateName(defaultName);
        }

        if (name.trim().length() < 5 ){
            System.out.println("The name least five characters. Please enter again.");
            return validateName(defaultName);
        }
        return name;
    }
    protected LocalDate validateDate (LocalDate defaultDate) {
        LocalDate date;
        System.out.print("Enter event's date (YYYY-MM-DD) ("+defaultDate+"): ");
        Scanner sc = new Scanner(System.in);
        String input_date = sc.nextLine();
        if (input_date.isEmpty()){
            return defaultDate;
        }
        try {
            date = LocalDate.parse(input_date);
        } catch (Exception e){
            System.out.println("Invalid date format. Please enter date in the format YYYY-MM-DD.");
            return validateDate(defaultDate);
        }
        return date;
    }
    protected String validateLocation (String defaultLocation) {
        System.out.print("Enter event's location ("+defaultLocation+"): ");
        Scanner sc = new Scanner(System.in);
        String location = sc.nextLine();
        if (location.isEmpty()){
            return defaultLocation;
        }
        return location;
    }
    protected int validateAttendees (int defaultAttendees) {
        int att;
        System.out.print("Enter the number of attendees ("+defaultAttendees+"): ");
        Scanner sc = new Scanner(System.in);
        String attendees = sc.nextLine();
        if (attendees.isEmpty()) {
            return defaultAttendees;
        }
        try {
            att = Integer.parseInt(attendees);
            if (att <= 0)
                throw new Exception("Enter positive number");
        } catch (NumberFormatException e) {
            System.out.println("Invalid the number of attendees format!");
            return validateAttendees(defaultAttendees);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return validateAttendees(defaultAttendees);
        }
        return att;
    }
    protected boolean validateStatus (boolean defaultStatus) {
        String status_default = defaultStatus ? "Available" : "Not Available";
        System.out.println("\nEnter event's status ("+status_default+"): ");
        System.out.println("1. Available");
        System.out.println("2. Not Available");
        System.out.print("Your choice: ");
        boolean status;
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.isEmpty())
            return defaultStatus;
        try {
            int input_status = Integer.parseInt(input);
            if (input_status == 1)
                status = true;
            else if (input_status == 2)
                status = false;
            else {
                System.out.println("Just choice 1 or 2!");
                return validateStatus(defaultStatus);
            }
        }catch (NumberFormatException e) {
            System.out.println("Just choice 1 or 2!");
            return validateStatus(defaultStatus);
        }
        return status;
    }
}
