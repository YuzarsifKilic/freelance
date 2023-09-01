package com.yuzarsif.freelance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class Employee extends User {

    private String resume;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Set<FinishedAdvertisement> finishedAdvertisements = new HashSet<>();
}
