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
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private MainCategory mainCategory;
    private String subCategoryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Tag> tags = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "category_advertisement",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "advertisement_id")
    )
    private Set<Advertisement> advertisements = new HashSet<>();
}
