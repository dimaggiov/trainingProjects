package com.mthree.service;

import com.mthree.data.GameDao;
import com.mthree.data.RoundDao;
import com.mthree.models.Game;
import com.mthree.models.Round;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class GameService {

    private final GameDao gameDao;
    private final RoundDao roundDao;

    public GameService(GameDao gameDao, RoundDao roundDao) {
        this.gameDao = gameDao;
        this.roundDao = roundDao;
    }

    public int addGame() {
        Game game = new Game();
        game.setAnswer(generateAnswer());
        game.setInProgress(true);
        gameDao.addGame(game);
        return game.getId();
    }

    public Round guess(Round round) {
        if(! (gameDao.findById(round.getGameID()).isInProgress()))
            return null;

        round.setTime(new Timestamp(ZonedDateTime.now().toInstant().toEpochMilli()));
        round.setGuessResults(calculateResults(round));
        roundDao.addRound(round);

        if (round.getGuessResults().charAt(2) == '4')
            finishGame(round.getGameID());

        return round;
    }

    public List<Game> getAllValidGames() {
        List<Game> allGames = gameDao.getAllGames();
        for (Game g: allGames) {
            if(g.isInProgress())
                g.setAnswer("");
        }

        return allGames;
    }

    public Game getGameById(int gameId) {
        Game game = gameDao.findById(gameId);
        if(game.isInProgress())
            game.setAnswer("");

        return game;
    }

    public List<Round> getRoundsForGame(int gameId){
        List<Round> rounds = roundDao.getRoundsForGame(gameId);

        rounds.sort(new Comparator<Round>() {
            @Override
            public int compare(Round o1, Round o2) {
                return o1.getTime().compareTo(o2.getTime());
            }
        });

        return rounds;
    }



    private void finishGame(int id) {
        Game gameToFinish = gameDao.findById(id);
        gameToFinish.setInProgress(false);
        gameDao.update(gameToFinish);
    }

    private String calculateResults(Round round) {
        Game game = gameDao.findById(round.getGameID());

        int exactMatches = 0;
        int partialMatches = 0;
        for(int i = 0; i < 4; i++) {
            if (round.getGuess().charAt(i) == game.getAnswer().charAt(i)) {
                exactMatches++;
            }
            for(int j = 0; j < 4; j++) {
                if(i == j)
                    continue;
                if(round.getGuess().charAt(i) == game.getAnswer().charAt(j))
                    partialMatches++;
            }
        }

        return "e:" + exactMatches + "p:" +partialMatches;
    }


    private String generateAnswer() {
        List<Integer> integerList = new ArrayList<>();
        for(int i = 0 ; i < 10; i++){
            integerList.add(i);
        }
        Collections.shuffle(integerList);
        return "" + integerList.get(0) + integerList.get(1) +integerList.get(2) +integerList.get(3);
    }



}
