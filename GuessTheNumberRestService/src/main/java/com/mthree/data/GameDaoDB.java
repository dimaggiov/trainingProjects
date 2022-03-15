package com.mthree.data;

import com.mthree.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class GameDaoDB implements GameDao {


    private final JdbcTemplate jdbc;

    @Autowired
    public GameDaoDB(JdbcTemplate jdbc){this.jdbc = jdbc;}

    @Override
    public Game addGame(Game game) {
       final String sql = "INSERT INTO game(answer, inProgress) VALUES(?,?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbc.update((Connection conn) -> {

            PreparedStatement stmnt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmnt.setString(1, game.getAnswer());
            stmnt.setBoolean(2, game.isInProgress());
            return stmnt;
        }, keyHolder);

        game.setId(keyHolder.getKey().intValue());
        return game;
    }

    @Override
    public List<Game> getAllGames() {
        final String sql = "SELECT * FROM game;";
        return jdbc.query(sql, new GameMapper());
    }

    @Override
    public Game findById(int id) {
        try {
            final String sql = "SELECT * FROM game WHERE  id = ?;";
            return jdbc.queryForObject(sql, new GameMapper(), id);
        } catch(DataAccessException e) {
            return null;
        }
    }

    @Override
    public boolean update(Game game) {
        final String sql = "UPDATE game SET " +
                "answer = ?," +
                "inProgress = ? " +
                "WHERE id = ?;";

        return jdbc.update(sql,
                game.getAnswer(),
                game.isInProgress(),
                game.getId()) > 0;
    }

    @Override
    public boolean deleteById(int id) {
        final String sql = "DELETE FROM game WHERE id = ?;";
        return jdbc.update(sql,id) > 0;
    }

    private static final class GameMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet resultSet, int i) throws SQLException {
            Game game = new Game();
            game.setId(resultSet.getInt("id"));
            game.setAnswer(resultSet.getString("answer"));
            game.setInProgress(resultSet.getBoolean("inProgress"));
            return game;
        }
    }
}
