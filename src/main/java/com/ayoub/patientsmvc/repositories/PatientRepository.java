package com.ayoub.patientsmvc.repositories;

import com.ayoub.patientsmvc.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
