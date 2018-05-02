package com.example.mihai.tourguide;

public class Attraction {

    private int Name, Description, WorkingHours, Location, Contact, Website, imageResourceId;

    public Attraction() {
    }

    public Attraction(int name, int description, int workingHours, int location, int website, int imageResourceId) {
        Name = name;
        Description = description;
        WorkingHours = workingHours;
        Location = location;
        Website = website;
        this.imageResourceId = imageResourceId;
    }

    public Attraction(int name, int description, int workingHours, int location, int contact, int website, int imageResourceId) {
        Name = name;
        Description = description;
        WorkingHours = workingHours;
        Location = location;
        Contact = contact;
        Website = website;
        this.imageResourceId = imageResourceId;
    }

    public int getName() {
        return Name;
    }

    public void setName(int name) {
        Name = name;
    }

    public int getDescription() {
        return Description;
    }

    public void setDescription(int description) {
        Description = description;
    }

    public int getWorkingHours() {
        return WorkingHours;
    }

    public void setWorkingHours(int workingHours) {
        WorkingHours = workingHours;
    }

    public int getLocation() {
        return Location;
    }

    public void setLocation(int location) {
        Location = location;
    }

    public int getContact() {
        return Contact;
    }

    public void setContact(int contact) {
        Contact = contact;
    }

    public int getWebsite() {
        return Website;
    }

    public void setWebsite(int website) {
        Website = website;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
