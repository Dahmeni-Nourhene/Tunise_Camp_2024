package com.example.tunisie_camp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRes;
    @Column(unique = true)
    private LocalDate dateArrivee;
    private LocalDate dateDepart;
    private int nbPersonnes;
    private double montant;
   
    @ManyToOne
    @JsonIgnore
    Utilisateur utilisateur;
}
