package edu.miu.domain;

public class Dentist {
    private int dentistId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public Dentist(int dentistId, String firstName, String lastName,
                   String email, String phoneNumber) {
        this.dentistId = dentistId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getDentistId() {
        return dentistId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}