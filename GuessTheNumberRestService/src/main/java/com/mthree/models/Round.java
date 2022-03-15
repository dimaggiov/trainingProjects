package com.mthree.models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class Round {

    private String guess;
    private String guessResults;
    private Timestamp time;
    private int id;
    private int gameID;

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public String getGuessResults() {
        return guessResults;
    }

    public void setGuessResults(String guessResults) {
        this.guessResults = guessResults;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return id == round.id && gameID == round.gameID && guess.equals(round.guess) && guessResults.equals(round.guessResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guess, guessResults, time, id, gameID);
    }
}
