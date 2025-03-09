package com.project.expensetracker.adapters.repositorys.jpa;

import com.project.expensetracker.adapters.repositorys.entitys.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, String> {

    List<ExpenseEntity> findAllByUserId(String userId);


    List<ExpenseEntity> findAllByUserIdAndCategory(String userId, String category);
}
