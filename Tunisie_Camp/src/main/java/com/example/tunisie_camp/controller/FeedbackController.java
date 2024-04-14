package com.example.tunisie_camp.controller;

import com.example.tunisie_camp.entity.Feedback;
import com.example.tunisie_camp.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }
    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        if (!feedbacks.isEmpty()) {
            return new ResponseEntity<>(feedbacks, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping
//    public ResponseEntity<List<Feedback>> getAllFeedbacksByUserId(@RequestParam Long userId) {
//        List<Feedback> feedbacks = feedbackService.getAllFeedbacksByUserId(userId);
//        if (feedbacks != null) {
//            return new ResponseEntity<>(feedbacks, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
//        return feedbackService.getFeedbackById(id)
//                .map(feedback -> new ResponseEntity<>(feedback, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

    @PostMapping
    public ResponseEntity<Feedback> submitFeedback(@PathVariable Long userId, @RequestBody Feedback feedback) {
        Feedback savedFeedback = feedbackService.saveFeedback(userId, feedback);
        if (savedFeedback != null) {
            return new ResponseEntity<>(savedFeedback, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable Long id, @RequestBody Feedback newFeedback) {
        Feedback updatedFeedback = feedbackService.updateFeedback(id, newFeedback);
        if (updatedFeedback != null) {
            return new ResponseEntity<>(updatedFeedback, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
