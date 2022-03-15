package com.mthree.models;


import java.util.Objects;

public class Game {

    private boolean inProgress;
    private String answer;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return inProgress == game.inProgress && id == game.id && answer.equals(game.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inProgress, answer, id);
    }
}
