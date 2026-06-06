package edu.miu.domain;

import java.time.LocalDate;
import java.time.Period;

public class Patient {
    private int patientId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDate dateOfBirth;

    public Patient(int patientId, String firstName, String lastName,
                   String phoneNumber, LocalDate dateOfBirth) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}