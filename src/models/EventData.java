package models;

import java.io.Serializable;
import java.time.LocalDate;

public class EventData implements Serializable {
    private int eventId;
    private String name;
    private LocalDate date;
    private String location;
    private int numberOfAttendees;
    private boolean status;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public String displayOfEvent() {
        return String.format(
                        "| %-10d | %-15s | %-10s | %-15s | %-10d | %-15s |" ,
                eventId, name, date, location, numberOfAttendees, (status ? "Available" : "Not Available")
        );
    }
}
