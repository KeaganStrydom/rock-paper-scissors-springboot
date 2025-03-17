package com.example.rock_paper_scissors.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Score {
    private int wins;
    private int losses;
    private int ties;

    public Score(int wins, int losses, int ties) {
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
    }

    public void increaseScoreByOutcome(Outcome outcome) {
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
}
