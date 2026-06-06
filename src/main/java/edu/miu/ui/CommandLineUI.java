package edu.miu.ui;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.miu.config.LocalDateAdapter;
import edu.miu.config.LocalTimeAdapter;
import edu.miu.service.AppointmentService;
import edu.miu.service.PatientService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class CommandLineUI {
    private final AppointmentService appointmentService;
    private final PatientService patientService;
    private final Scanner scanner;
    private final Gson gson;

    public CommandLineUI(AppointmentService appointmentService, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.scanner = new Scanner(System.in);

        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .registerTypeAdapter(LocalTime.class, new LocalTimeAdapter())
                .setPrettyPrinting()
                .create();
    }

    public void start() {
        while (true) {
            showMenu();

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> displayAsJson(appointmentService.getAllAppointmentsSortedDescending());
                case 2 -> displayAsJson(patientService.getAllPatients());
                case 3 -> displayAsJson(appointmentService.getQuarterlyUpcomingAppointments());
                case 4 -> {
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
        System.out.println("3. Display quarterly upcoming appointments");
        System.out.println("4. Exit");
        System.out.print("Choose option: ");
    }

    private void displayAsJson(Object data) {
        String json = gson.toJson(data);
        System.out.println(json);
    }
}