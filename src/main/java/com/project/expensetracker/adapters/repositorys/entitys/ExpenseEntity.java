package com.project.expensetracker.adapters.repositorys.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "expenses")
public class ExpenseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String description;

    @Column
    private Double amount;

    @Column
    private String category;

    @Column
    private LocalDate date;

//    @Column
//    private String userId;
}
