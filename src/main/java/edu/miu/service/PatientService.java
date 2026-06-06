package edu.miu.service;

import edu.miu.domain.Patient;
import edu.miu.repository.PatientRepository;

import java.util.List;

public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(int patientId) {
        return patientRepository.findById(patientId);
    }
}