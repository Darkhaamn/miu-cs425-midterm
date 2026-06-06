package edu.miu.service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import edu.miu.domain.Appointment;
import edu.miu.repository.AppointmentRepository;

public class AppointmentService {
    private AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointmentsSortedDescending() {
        return appointmentRepository.findAll()
                .stream()
                .sorted(
                        Comparator.comparing(Appointment::getAppointmentDate)
                                .thenComparing(Appointment::getAppointmentTime)
                                .reversed()
                )
                .toList();
    }

    public List<Appointment> getQuarterlyUpcomingAppointments() {
        LocalDate today = LocalDate.now();

        LocalDate nextQuarterStart = getNextQuarterStartDate(today);
        LocalDate nextQuarterEnd = nextQuarterStart.plusMonths(3).minusDays(1);

        return appointmentRepository.findAll()
                .stream()
                .filter(appointment ->
                        !appointment.getAppointmentDate().isBefore(nextQuarterStart)
                                && !appointment.getAppointmentDate().isAfter(nextQuarterEnd)
                )
                .sorted(
                        Comparator.comparing(Appointment::getAppointmentDate)
                                .thenComparing(Appointment::getAppointmentTime)
                )
                .toList();
    }

    private LocalDate getNextQuarterStartDate(LocalDate currentDate) {
        int currentMonth = currentDate.getMonthValue();
        int currentQuarter = ((currentMonth - 1) / 3) + 1;

        int nextQuarter = currentQuarter + 1;
        int year = currentDate.getYear();

        if (nextQuarter == 5) {
            nextQuarter = 1;
            year++;
        }

        int nextQuarterStartMonth = ((nextQuarter - 1) * 3) + 1;

        return LocalDate.of(year, nextQuarterStartMonth, 1);
    }
}