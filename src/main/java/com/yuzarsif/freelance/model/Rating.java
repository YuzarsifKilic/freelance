package com.yuzarsif.freelance.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ratings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private float evaluation;
    private String comment;

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ",employerEmail=" + employer.getEmail() +
                ",employeeEmail=" + employee.getEmail() +
                ", evaluation=" + evaluation +
                ", comment='" + comment + '\'' +
                '}';
    }
}
