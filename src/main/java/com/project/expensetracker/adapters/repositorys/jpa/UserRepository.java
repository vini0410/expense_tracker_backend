package com.project.expensetracker.adapters.repositorys.jpa;

import com.project.expensetracker.adapters.repositorys.entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
