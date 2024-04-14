package com.example.tunisie_camp.service;

import com.example.tunisie_camp.entity.Reservation;
import com.example.tunisie_camp.entity.Utilisateur;
import com.example.tunisie_camp.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation createReservation(Reservation reservation, Utilisateur utilisateur) {
        reservation.setUtilisateur(utilisateur);
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long id, Reservation reservationDetails) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée avec l'ID : " + id));

        // Mettre à jour les détails de la réservation
        reservation.setDateArrivee(reservationDetails.getDateArrivee());
        reservation.setDateDepart(reservationDetails.getDateDepart());
        reservation.setNbPersonnes(reservationDetails.getNbPersonnes());
        reservation.setMontant(reservationDetails.getMontant());

        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
