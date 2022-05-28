package com.tevolvers.models;

public class User {
    private String firstName;
    private String lastName;
    private int totalPrice;
    private boolean depositPaid;
    private String checkIn;
    private String checkOut;
    private String additionalNeeds;

    public int getId() {
        return id;
    }

    private int id;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean isDepositPaid() {
        return depositPaid;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public String getAdditionalNeeds() {
        return additionalNeeds;
    }
}
