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
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Rating> ratings = new HashSet<>();
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Appeal> appeals = new HashSet<>();
}
