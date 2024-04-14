package com.example.tunisie_camp.repository;

import com.example.tunisie_camp.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Ajoutez ici des méthodes personnalisées si nécessaire
}
