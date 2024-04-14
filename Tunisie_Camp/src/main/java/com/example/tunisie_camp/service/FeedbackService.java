package com.example.tunisie_camp.service;

import com.example.tunisie_camp.entity.Feedback;
import com.example.tunisie_camp.entity.Utilisateur;
import com.example.tunisie_camp.repository.FeedbackRepository;
import com.example.tunisie_camp.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository, UtilisateurRepository utilisateurRepository) {
        this.feedbackRepository = feedbackRepository;
        this.utilisateurRepository = utilisateurRepository;
    }
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }
    public List<Feedback> getAllFeedbacksByUserId(Long userId) {
        // Supposons que vous ayez une méthode dans UserRepository pour récupérer l'utilisateur par ID
        Utilisateur utilisateur = utilisateurRepository.findById(userId).orElse(null);
        if (utilisateur != null) {
            return utilisateur.getFeedbacks();
        }
        return null;
    }

    public Optional<Feedback> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    public Feedback saveFeedback(Long userId, Feedback feedback) {
        // Supposons que vous ayez une méthode dans UserRepository pour récupérer l'utilisateur par ID
        Utilisateur utilisateur = utilisateurRepository.findById(userId).orElse(null);
        if (utilisateur != null) {
            feedback.setUtilisateur(utilisateur);
            return feedbackRepository.save(feedback);
        }
        return null;
    }

    public Feedback updateFeedback(Long id, Feedback newFeedback) {
        return feedbackRepository.findById(id).map(feedback -> {
            feedback.setCommentaire(newFeedback.getCommentaire());
            feedback.setDateFeedback(newFeedback.getDateFeedback());
            feedback.setNote(newFeedback.getNote());
            // Mettez à jour d'autres champs au besoin
            return feedbackRepository.save(feedback);
        }).orElse(null); // Gérer le cas où l'ID de feedback n'est pas trouvé
    }

    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}
