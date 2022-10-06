package com.ayoub.patientsmvc.web;

import com.ayoub.patientsmvc.entities.Patient;
import com.ayoub.patientsmvc.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping("/patient")
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String patients(Model model, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "4") int size) {
        Page<Patient> pagePatients = patientRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("patientList", pagePatients);
        model.addAttribute("numberOfPages", new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        System.out.println(pagePatients.getTotalPages());
        return "patients";
    }


}
