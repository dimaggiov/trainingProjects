package com.mthree.data;

import com.mthree.TestApplicationConfiguration;
import com.mthree.models.Game;
import com.mthree.models.Round;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class RoundDaoDBTest {

    @Autowired
    GameDao gameDao;

    @Autowired
    RoundDao roundDao;

    @Before
    public void setUp(){
        List<Game> games = gameDao.getAllGames();

        for(Game game : games){
            List<Round> rounds = roundDao.getRoundsForGame(game.getId());
            for(Round round : rounds)
                roundDao.deleteById(round.getId());
            gameDao.deleteById(game.getId());
        }



    }

    @Test
    public void testGetAllRounds(){
        Game game = new Game();
        game.setAnswer("1234");
        game.setInProgress(true);
        gameDao.addGame(game);
        Game game2 = new Game();
        game2.setAnswer("4561");
        game2.setInProgress(true);
        gameDao.addGame(game2);

        Round round = new Round();
        round.setTime(new Timestamp(ZonedDateTime.now().toInstant().toEpochMilli()));
        round.setGameID(game.getId());
        round.setGuess("1234");
        round.setGuessResults("e:4p:0");
        round = roundDao.addRound(round);

        Round round2 = new Round();
        round2.setTime(new Timestamp(ZonedDateTime.now().toInstant().toEpochMilli()));
        round2.setGameID(game2.getId());
        round2.setGuess("4516");
        round2.setGuessResults("e:2p:2");
        round2 = roundDao.addRound(round2);

        List<Round> allRounds = roundDao.getAllRounds();

        assertEquals(2, allRounds.size());
        assertTrue(allRounds.contains(round));
        assertTrue(allRounds.contains(round2));

    }

    @Test
    public void testAddGetRound(){
        Game game = new Game();
        game.setAnswer("1234");
        game.setInProgress(true);
        gameDao.addGame(game);

        Round round = new Round();
        round.setTime(new Timestamp(ZonedDateTime.now().toInstant().toEpochMilli()));
        round.setGameID(game.getId());
        round.setGuess("1234");
        round.setGuessResults("e:4p:0");
        round = roundDao.addRound(round);

        Round fromDao = roundDao.findById(round.getId());
        assertEquals(round,fromDao);

    }

    @Test
    public void testDeleteRoundById(){
        Game game = new Game();
        game.setAnswer("1234");
        game.setInProgress(true);
        gameDao.addGame(game);

        Round round = new Round();
        round.setTime(new Timestamp(ZonedDateTime.now().toInstant().toEpochMilli()));
        round.setGameID(game.getId());
        round.setGuess("1234");
        round.setGuessResults("e:4p:0");
        round = roundDao.addRound(round);

        roundDao.deleteById(round.getId());

        Round fromDao = roundDao.findById(round.getId());
        assertNull(fromDao);
    }

    @Test
    public void testUpdate(){
        Game game = new Game();
        game.setAnswer("1234");
        game.setInProgress(true);
        gameDao.addGame(game);

        Round round = new Round();
        round.setTime(new Timestamp(ZonedDateTime.now().toInstant().toEpochMilli()));
        round.setGameID(game.getId());
        round.setGuess("1234");
        round.setGuessResults("e:4p:0");
        round = roundDao.addRound(round);

        round.setGuessResults("e:3p:1");
        roundDao.update(round);
        Round fromDao = roundDao.findById(round.getId());

        assertEquals(round,fromDao);

    }


}
