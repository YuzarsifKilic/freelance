package com.yuzarsif.freelance.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Employer extends User {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employer")
    private Set<Advertisement> advertisements = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employer")
    private Set<Rating> ratings = new HashSet<>();
}
