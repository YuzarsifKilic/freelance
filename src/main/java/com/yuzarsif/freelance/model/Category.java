package com.yuzarsif.freelance.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Category extends MainCategory {

    @ManyToOne
    @JoinColumn(name = "category_id")
    private MainCategory mainCategory;
    private String subCategoryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Tag> tags = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Advertisement> advertisements = new HashSet<>();
}
