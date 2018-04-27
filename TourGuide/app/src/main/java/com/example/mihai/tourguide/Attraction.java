package com.example.mihai.tourguide;

public class Attraction {

    private String Name, Description, WorkingHours, Location, Contact, Website;
    private int imageResourceId;

    public Attraction() {
    }

    public Attraction(String name, String description, String workingHours, String location, String website, int imageResourceId) {
        Name = name;
        Description = description;
        WorkingHours = workingHours;
        Location = location;
        Website = website;
        this.imageResourceId = imageResourceId;
    }

    public Attraction(String name, String description, String workingHours, String location, String contact, String website, int imageResourceId) {
        Name = name;
        Description = description;
        WorkingHours = workingHours;
        Location = location;
        Contact = contact;
        Website = website;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getWorkingHours() {
        return WorkingHours;
    }

    public void setWorkingHours(String workingHours) {
        WorkingHours = workingHours;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
