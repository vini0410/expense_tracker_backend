package com.project.expensetracker.adapters.repositorys.jpa;

import com.project.expensetracker.adapters.repositorys.entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByEmail(String email);

    List<UserEntity> findAllByEmail(String email);
}
