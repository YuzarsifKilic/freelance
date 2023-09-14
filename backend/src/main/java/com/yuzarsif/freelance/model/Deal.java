package com.yuzarsif.freelance.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "deals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
                         CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "advertisement_id")
    private Advertisement advertisement;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @CreationTimestamp
    private LocalDateTime dealDate;
}
