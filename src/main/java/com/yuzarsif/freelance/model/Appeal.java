package com.yuzarsif.freelance.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "appeals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Appeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "advertisement_id")
    private Advertisement advertisement;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private String commitment;
    private boolean isSeen;
}
