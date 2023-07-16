package com.example.astrotalk.repo;

import com.example.astrotalk.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<PatientEntity,Integer> {
    List<PatientEntity> findAllByStatus(String admitted);
}
