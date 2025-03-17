package com.example.rock_paper_scissors.models;

import java.util.Random;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameState {
    private Move userMove;
    private Move computerMove;

    private Outcome outcome;
    private int wins;
    private int losses;
    private int ties;

    public GameState(int wins, int losses, int ties) {
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
        this.userMove = Move.ROCK;
        this.computerMove = Move.ROCK;
    }

    public void increaseScoreByOutcome(Outcome outcome) {
        this.outcome = outcome;
        switch (outcome) {
            case WIN:
                this.wins++;
                break;
            case LOSS:
                this.losses++;
                break;
            case TIE:
                this.ties++;
                break;
            default:
                break;
        }
    }


    public void performUserMove(Move userMove) {
        // Perform random computer move
        int computerMoveIndex = (new Random()).nextInt(Move.values().length);
        this.userMove = userMove;
        this.computerMove =  Move.values()[computerMoveIndex];

        if (computerMove == userMove) {
            increaseScoreByOutcome(Outcome.TIE);
        } else if (userMove == Move.ROCK) { // Computer is not rock
            if (computerMove == Move.SCISSORS) {
                increaseScoreByOutcome(Outcome.WIN);// User wins (Rock beats scissors)
            } else {
                increaseScoreByOutcome(Outcome.LOSS); // Computer wins (Rock loses against paper)
            }
        } else if (userMove == Move.PAPER) { // Computer is not paper
            if (computerMove == Move.ROCK) {
                increaseScoreByOutcome(Outcome.WIN);// User wins (Paper beats rock)
            } else {
                increaseScoreByOutcome(Outcome.LOSS);// Computer wins (Paper loses against scissors)
            }
        } else { // User must be Scissors and Computer is not Scissors
            if (computerMove == Move.PAPER) {
                increaseScoreByOutcome(Outcome.WIN);// User wins (Scissors beats paper)
            } else {
                increaseScoreByOutcome(Outcome.LOSS);// Computer wins (Scissors losses against rock)
            }
        }
    }
}
