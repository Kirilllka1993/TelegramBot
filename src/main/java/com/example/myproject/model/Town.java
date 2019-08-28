package com.example.myproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "town")
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "town_name")
    private String townName;
    @Column(name = "description")
    private String description;
    @Column(name = "country")
    private String country;
    @Column(name = "foundation_year")
    private String foundationYear;

}
