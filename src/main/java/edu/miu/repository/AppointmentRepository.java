package edu.miu.repository;

import edu.miu.domain.Appointment;
import edu.miu.domain.Dentist;
import edu.miu.domain.Patient;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {
    private final List<Appointment> appointments = new ArrayList<>();

    public AppointmentRepository() {
        loadAppointments();
    }

    private void loadAppointments() {
        Dentist dentist1 = new Dentist(
                1,
                "Michael",
                "Brown",
                "michael.brown@ads.com",
                "(641) 555-1111"
        );

        Dentist dentist2 = new Dentist(
                2,
                "Sarah",
                "Wilson",
                "sarah.wilson@ads.com",
                "(319) 555-2222"
        );

        Patient patient1 = new Patient(
                1,
                "John",
                "Smith",
                "(641) 001-1234",
                LocalDate.of(1987, 1, 19)
        );

        Patient patient2 = new Patient(
                2,
                "Anna",
                "Jones",
                "(319) 716-1987",
                LocalDate.of(2001, 7, 26)
        );

        Patient patient3 = new Patient(
                3,
                "Carlos",
                "Jimenez",
                "(319) 098-7711",
                LocalDate.of(1969, 11, 5)
        );

        Patient patient4 = new Patient(
                4,
                "Albert",
                "Einstein",
                "(641) 119-6142",
                LocalDate.of(1955, 12, 28)
        );

        appointments.add(new Appointment(
                1,
                LocalDate.of(2026, 2, 28),
                LocalTime.of(10, 5),
                patient1,
                dentist1
        ));

        appointments.add(new Appointment(
                2,
                LocalDate.of(2025, 12, 31),
                LocalTime.of(13, 45),
                patient2,
                dentist2
        ));

        appointments.add(new Appointment(
                3,
                LocalDate.of(2027, 5, 4),
                LocalTime.of(14, 0),
                patient3,
                dentist1
        ));

        appointments.add(new Appointment(
                4,
                LocalDate.of(2026, 9, 16),
                LocalTime.of(11, 15),
                patient4,
                dentist2
        ));
    }

    public List<Appointment> findAll() {
        return appointments;
    }

    public Appointment findById(int appointmentId) {
        return appointments.stream()
                .filter(appointment -> appointment.getAppointmentId() == appointmentId)
                .findFirst()
                .orElse(null);
    }
}