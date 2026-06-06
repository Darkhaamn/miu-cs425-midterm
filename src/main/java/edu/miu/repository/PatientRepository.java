package edu.miu.repository;

import edu.miu.domain.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository {
    private final List<Patient> patients = new ArrayList<>();

    public PatientRepository() {
        loadPatients();
    }

    private void loadPatients() {
        patients.add(new Patient(
                1,
                "John",
                "Smith",
                "(641) 001-1234",
                LocalDate.of(1987, 1, 19)
        ));

        patients.add(new Patient(
                2,
                "Anna",
                "Jones",
                "(319) 716-1987",
                LocalDate.of(2001, 7, 26)
        ));

        patients.add(new Patient(
                3,
                "Carlos",
                "Jimenez",
                "(319) 098-7711",
                LocalDate.of(1969, 11, 5)
        ));

        patients.add(new Patient(
                4,
                "Albert",
                "Einstein",
                "(641) 119-6142",
                LocalDate.of(1955, 12, 28)
        ));
    }

    public List<Patient> findAll() {
        return patients;
    }

    public Patient findById(int patientId) {
        return patients.stream()
                .filter(patient -> patient.getPatientId() == patientId)
                .findFirst()
                .orElse(null);
    }
}