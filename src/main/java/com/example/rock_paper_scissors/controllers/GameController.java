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
public class GameController {

    static GameState game = new GameState(0,0,0);
    
    @GetMapping("/game/health-check")
    public String getHealthCehck() {
        return "Application is built and running. SNAFU (Situation Normal All Fired Up!)";
    }

    @GetMapping("/game")
    public GameState getState() {
        return game;
    }


    @PostMapping("/game/{move}")
    public GameState userMove(@PathVariable String move) {
        try {
            Move userMove = Move.valueOf(move.toUpperCase());
            game.performUserMove(userMove);
            return game;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid game move. Must be ROCK, PAPER or SCISSORS.");
        }
    }


    @PutMapping("/game/reset")
    public GameState resetScore() {
        game.setTies(0);
        game.setWins(0);
        game.setLosses(0);
        return game;
    }

}
