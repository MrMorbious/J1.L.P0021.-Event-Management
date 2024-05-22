package controllers.validators;

import models.EventData;

import java.time.LocalDate;
import java.util.Scanner;

public class EventCreateValidator {

    protected String validateName(){
        System.out.print("Enter event's name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        if (name.contains(" ")){
            System.out.println("The name not allow contain space characters. Please enter again.");
            return validateName();
        }

        if (name.trim().length() < 5 ){
            System.out.println("The name least five characters. Please enter again.");
            return validateName();
        }
        if(name.isEmpty()) {
            System.out.println("Event's name not empty! Please enter again.");
            return validateName();
        }

        return name;

    }
    protected LocalDate validateDate () {
        LocalDate date;
        System.out.print("Enter event's date (YYYY-MM-DD): ");
        Scanner sc = new Scanner(System.in);
        String input_date = sc.nextLine();

        if (input_date.trim().isEmpty()){
            System.out.println("Event's date cannot be empty!");
            return validateDate();
        }
        try {
            date = LocalDate.parse(input_date);
        } catch (Exception e){
            System.out.println("Invalid date format. Please enter date in the format YYYY-MM-DD.");
            return validateDate();
        }
         return date;
    }
    protected String validateLocation () {
        System.out.print("Enter event's location: ");
        Scanner sc = new Scanner(System.in);
        String location = sc.nextLine();

        if (location.isEmpty()){
            System.out.println("Event's location not empty!");
            return validateLocation();
        }
        return location;
    }
    protected int validateAttendees () {
        int att;
        System.out.print("Enter the number of attendees: ");
        Scanner sc = new Scanner(System.in);
        String attendees = sc.nextLine();
        if (attendees.isEmpty()) {
            System.out.println("The number of attendees cannot empty!");
            return validateAttendees();
        }

        try {
                att = Integer.parseInt(attendees);
            if (att <= 0)
                throw new Exception("Attendees must be a positive integer!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid the number of attendees format!");
            return validateAttendees();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return validateAttendees();
        }
        return att;
    }
    protected boolean validateStatus () {
        System.out.println("\nEnter event's status: ");
        System.out.println("1. Available");
        System.out.println("2. Not Available");
        System.out.print("Your choice: ");
        boolean status;
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.isEmpty()){
            System.out.println("Event's status cannot empty!");
            return validateStatus();
        }
        try {
            int input_status = Integer.parseInt(input);
            if (input_status == 1)
                status = true;
            else if (input_status == 2)
                status = false;
            else {
                System.out.println("Just choice 1 or 2!");
                return validateStatus();
            }
        } catch (NumberFormatException e) {
            System.out.println("Just choice 1 or 2!");
            return validateStatus();
        }
        return status;
    }
}
