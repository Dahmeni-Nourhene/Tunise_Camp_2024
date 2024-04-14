package com.example.tunisie_camp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Lieux {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLieux;
    @Column(unique = true)
    private String nom;
    private String description;
    private int capacite;
    private double tarifNuit;



}
