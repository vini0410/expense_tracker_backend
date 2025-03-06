package com.project.expensetracker.adapters.repositorys.jpa;

import com.project.expensetracker.adapters.repositorys.entitys.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, String> {


}
