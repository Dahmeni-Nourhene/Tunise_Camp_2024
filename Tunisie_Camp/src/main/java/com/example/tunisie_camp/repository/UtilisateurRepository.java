package com.example.tunisie_camp.repository;
import com.example.tunisie_camp.entity.Feedback;
import com.example.tunisie_camp.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
