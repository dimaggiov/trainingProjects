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
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class GameDaoDBTest {

    @Autowired
    GameDao gameDao;

    @Autowired
    RoundDao roundDao;

    @Before
    public void setUp(){
        List<Game> games = gameDao.getAllGames();
        for(Game game : games){
            gameDao.deleteById(game.getId());
        }

        List<Round> rounds = roundDao.getAllRounds();
        for(Round round : rounds)
            roundDao.deleteById(round.getId());

    }

    @Test
    public void testAddGetGame(){
        Game game = new Game();
        game.setAnswer("1234");
        game.setInProgress(true);
        game = gameDao.addGame(game);

        Game fromDao = gameDao.findById(game.getId());

        assertEquals(game, fromDao);
    }

    @Test
    public void testGetAllGames(){
        Game game = new Game();
        game.setAnswer("1234");
        game.setInProgress(true);
        gameDao.addGame(game);

        Game game2 = new Game();
        game2.setAnswer("4561");
        game2.setInProgress(true);
        gameDao.addGame(game2);

        List<Game> games = gameDao.getAllGames();

        assertEquals(2, games.size());
        assertTrue(games.contains(game));
        assertTrue(games.contains(game2));
    }

    @Test
    public void testDeleteGameById() {
        Game game = new Game();
        game.setAnswer("1234");
        game.setInProgress(true);
        game = gameDao.addGame(game);

        Game game2 = new Game();
        game2.setAnswer("4561");
        game2.setInProgress(true);
        game2 = gameDao.addGame(game2);

        gameDao.deleteById(game.getId());

        Game fromDao = gameDao.findById(game.getId());
        assertNull(fromDao);
    }

    @Test
    public void testUpdate(){
        Game game = new Game();
        game.setAnswer("1234");
        game.setInProgress(true);
        game = gameDao.addGame(game);

        game.setAnswer("5132");
        gameDao.update(game);

        Game fromDao = gameDao.findById(game.getId());

        assertEquals(game, fromDao);
    }

}
