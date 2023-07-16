package com.example.astrotalk.service;

import com.example.astrotalk.entity.PatientEntity;
import com.example.astrotalk.entity.UserEntity;
import com.example.astrotalk.repo.PatientRepo;
import com.example.astrotalk.repo.UserRepo;
//import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo repo;
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepo repo, PatientRepo patientRepo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.patientRepo = patientRepo;
        this.passwordEncoder = passwordEncoder;
    }


    public String registerNewUser(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        repo.save(userEntity);
        return "user added to system ";

    }

//    public String userLogin(UserEntity userEntity) {
//        // Retrieve the user from the repository based on the provided username
//        UserEntity existingUser = repo.findByUser(userEntity.getUser());
//
//        // Check if the user exists and compare the password
//        if (existingUser != null && existingUser.getPassword().equals(userEntity.getPassword())) {
//            return "Login successful";
//        }
//
//        return "Invalid username or password";
//    }

    public PatientEntity newPatient(PatientEntity patientEntity) {
        patientEntity.setStatus("admitted"); // Set the default status as "admitted"
        return patientRepo.save(patientEntity);
    }

    public List<PatientEntity> getAllAdmitPatient() {
        return patientRepo.findAllByStatus("admitted");
    }

    public String dischargedPateint(Integer id) {
        PatientEntity patientEntity = patientRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        patientEntity.setStatus("discharged");
        patientRepo.save(patientEntity);

        return "Patient discharged successfully";
    }
}

