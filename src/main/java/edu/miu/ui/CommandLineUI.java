package edu.miu.ui;

import edu.miu.domain.Appointment;
import edu.miu.domain.Patient;
import edu.miu.service.AppointmentService;
import edu.miu.service.PatientService;

import java.util.List;
import java.util.Scanner;

public class CommandLineUI {
    private final AppointmentService appointmentService;
    private final PatientService patientService;
    private final Scanner scanner;

    public CommandLineUI(AppointmentService appointmentService, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            showMenu();

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> displayAppointmentsAsJson(appointmentService.getAllAppointmentsSortedDescending());
                case 2 -> displayPatientsAsJson(patientService.getAllPatients());
                case 3 -> {
                    System.out.println("Application closed.");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\nADS Dental Appointment Management System");
        System.out.println("1. Display all appointments");
        System.out.println("2. Display all patients");
        System.out.println("3. Exit");
        System.out.print("Choose option: ");
    }

    private void displayPatientsAsJson(List<Patient> patients) {
        System.out.println("[");
        for (int i = 0; i < patients.size(); i++) {
            Patient p = patients.get(i);

            System.out.println("  {");
            System.out.println("    \"patientId\": " + p.getPatientId() + ",");
            System.out.println("    \"firstName\": \"" + p.getFirstName() + "\",");
            System.out.println("    \"lastName\": \"" + p.getLastName() + "\",");
            System.out.println("    \"fullName\": \"" + p.getFullName() + "\",");
            System.out.println("    \"phoneNumber\": \"" + p.getPhoneNumber() + "\",");
            System.out.println("    \"dateOfBirth\": \"" + p.getDateOfBirth() + "\"");
            System.out.print("  }");

            if (i < patients.size() - 1) {
                System.out.println(",");
            } else {
                System.out.println();
            }
        }
        System.out.println("]");
    }

    private void displayAppointmentsAsJson(List<Appointment> appointments) {
        System.out.println("[");
        for (int i = 0; i < appointments.size(); i++) {
            Appointment a = appointments.get(i);
            Patient p = a.getPatient();

            System.out.println("  {");
            System.out.println("    \"appointmentId\": " + a.getAppointmentId() + ",");
            System.out.println("    \"appointmentDate\": \"" + a.getAppointmentDate() + "\",");
            System.out.println("    \"appointmentTime\": \"" + a.getAppointmentTime() + "\",");
            System.out.println("    \"patient\": {");
            System.out.println("      \"patientId\": " + p.getPatientId() + ",");
            System.out.println("      \"firstName\": \"" + p.getFirstName() + "\",");
            System.out.println("      \"lastName\": \"" + p.getLastName() + "\",");
            System.out.println("      \"fullName\": \"" + p.getFullName() + "\",");
            System.out.println("      \"phoneNumber\": \"" + p.getPhoneNumber() + "\",");
            System.out.println("      \"dateOfBirth\": \"" + p.getDateOfBirth()+ "\"");
            System.out.println("    },");
            System.out.println("    \"dentist\": {");
            System.out.println("      \"dentistId\": " + a.getDentist().getDentistId() + ",");
            System.out.println("      \"firstName\": \"" + a.getDentist().getFirstName() + "\",");
            System.out.println("      \"lastName\": \"" + a.getDentist().getLastName() + "\",");
            System.out.println("      \"email\": \"" + a.getDentist().getEmail() + "\",");
            System.out.println("      \"phoneNumber\": \"" + a.getDentist().getPhoneNumber() + "\"");
            System.out.println("    }");
            System.out.print("  }");

            if (i < appointments.size() - 1) {
                System.out.println(",");
            } else {
                System.out.println();
            }
        }
        System.out.println("]");
    }
}