package com.example.astrotalk.controller;

import com.example.astrotalk.entity.PatientEntity;
import com.example.astrotalk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private UserService userService;



    public PatientController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/newPatient")
    @PreAuthorize("hasAuthority('STAFF')")
    public  PatientEntity newPatient(@RequestBody PatientEntity patientEntity){
        return userService.newPatient(patientEntity);
    }
    @GetMapping("/admitPatient")
    public  List<PatientEntity> getAllAdmittedPatient(){
        return userService.getAllAdmitPatient();
    }
    @DeleteMapping("/{id}/discharge")
    @PreAuthorize("hasAuthority('STAFF')")
    public String dischargedPatent(@PathVariable Integer id){
        return userService.dischargedPateint(id);
    }
}
