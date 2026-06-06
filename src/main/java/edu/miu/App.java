package edu.miu;

import edu.miu.repository.AppointmentRepository;
import edu.miu.repository.PatientRepository;
import edu.miu.service.AppointmentService;
import edu.miu.service.PatientService;
import edu.miu.ui.CommandLineUI;

public class App {
    public static void main(String[] args) {
        PatientRepository patientRepository = new PatientRepository();
        AppointmentRepository appointmentRepository = new AppointmentRepository();

        PatientService patientService = new PatientService(patientRepository);
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);

        CommandLineUI ui = new CommandLineUI(appointmentService, patientService);
        ui.start();
    }
}