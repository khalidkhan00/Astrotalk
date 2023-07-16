package com.example.astrotalk.repo;

import com.example.astrotalk.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {



    Optional<UserEntity> findByUser(String username);
}
