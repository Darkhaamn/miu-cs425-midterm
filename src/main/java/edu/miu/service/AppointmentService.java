package edu.miu.service;

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
}