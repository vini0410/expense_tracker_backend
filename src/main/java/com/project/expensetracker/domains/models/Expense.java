package com.project.expensetracker.domains.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    private String id;
    private String description;
    private Double amount;
    private String category;
    private LocalDate date;
//    private String userId;
}
