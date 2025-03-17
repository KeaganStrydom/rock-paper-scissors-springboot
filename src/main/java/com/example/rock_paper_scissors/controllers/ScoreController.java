package com.example.rock_paper_scissors.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.rock_paper_scissors.models.*;

@RestController
@CrossOrigin // Allows REST API to be invoked by resources not on the same domain.
public class ScoreController {

    static Score defaultScore = new Score(0,0,0);
    
    @GetMapping("/health-check")
    public String getHealthCehck() {
        return "Application is built and running. SNAFU (Situation Normal All Fired Up!)";
    }


    @PostMapping("/score/{outcome}")
    public Score increaseScoreByOutcome(@PathVariable String outcome) {
        try {
            Outcome gameOutcome = Outcome.valueOf(outcome);
            defaultScore.increaseScoreByOutcome(gameOutcome);
            return defaultScore;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid game outcome. Must be WIN, LOSS or TIE.");
        }
    }

    @GetMapping("/score/{type}")
    public Integer getScoreByType(@PathVariable String type) {
        switch (type.toLowerCase()) {
            case "wins":
                return defaultScore.getWins();
            case "losses":
                return defaultScore.getLosses();
            case "ties":
                return defaultScore.getTies();
            default:
                return 0;
        }
    }

    @PutMapping("/score/reset")
    public Score resetScore() {
        defaultScore.setTies(0);
        defaultScore.setWins(0);
        defaultScore.setLosses(0);
        return defaultScore;
    }

}
