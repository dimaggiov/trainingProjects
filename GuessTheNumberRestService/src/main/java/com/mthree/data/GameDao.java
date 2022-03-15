package com.mthree.data;

import com.mthree.models.Game;

import java.util.List;

public interface GameDao {

    Game addGame(Game game);

    List<Game> getAllGames();

    Game findById(int id);

    boolean update(Game game);

    boolean deleteById(int id);
}
