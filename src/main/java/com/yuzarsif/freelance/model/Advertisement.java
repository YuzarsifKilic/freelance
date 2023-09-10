package com.yuzarsif.freelance.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "advertisements")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String header;
    private String description;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "category_advertisement",
            joinColumns = @JoinColumn(name = "advertisement_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> category = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "tag_advertisement",
            joinColumns = @JoinColumn(name = "advertisement_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;
    private boolean isDone;
    private int price;
    private int duration;
    private int views;
    @CreationTimestamp
    public LocalDateTime createdDate;
    @UpdateTimestamp
    public LocalDateTime updatedDate;
    @OneToMany(mappedBy = "advertisement",cascade = CascadeType.ALL)
    private Set<Appeal> appeals = new HashSet<>();
}
