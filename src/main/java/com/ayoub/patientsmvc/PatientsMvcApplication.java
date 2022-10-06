package com.ayoub.patientsmvc;

import com.ayoub.patientsmvc.entities.Patient;
import com.ayoub.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    @Bean
    CommandLineRunner start(PatientRepository patientRepository) {
        return args -> {
                     patientRepository.save(new Patient(null, "ayoub", new Date(), false, 12));
                    patientRepository.save(new Patient(null, "hafidi", new Date(), true, 13));
                    patientRepository.save(new Patient(null, "alaoui", new Date(), false, 16));
                    patientRepository.findAll().forEach(p -> System.out.println(p.getName()));
        };
    }

}
