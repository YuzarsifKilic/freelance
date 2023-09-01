package com.yuzarsif.freelance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "finished_advertisements")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FinishedAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "advertisement_id")
    private Advertisement advertisement;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private int rating;
    private String comments;
}
