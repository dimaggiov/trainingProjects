package com.mthree.data;

import com.mthree.models.Round;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class RoundDaoDB implements RoundDao{

    private JdbcTemplate jdbc;

    @Autowired
    public RoundDaoDB(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Round addRound(Round round) {
       final String sql = "INSERT INTO round(guess, guessResults, time, gameID) " +
               "VALUES(?,?,?,?);";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbc.update((Connection conn) -> {

            PreparedStatement stmnt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmnt.setString(1,round.getGuess());
            stmnt.setString(2, round.getGuessResults());
            stmnt.setTimestamp(3,round.getTime());
            stmnt.setInt(4,round.getGameID());

            return stmnt;
        }, keyHolder);

        round.setId(keyHolder.getKey().intValue());
        return round;
    }

    @Override
    public List<Round> getAllRounds() {
       final String sql = "SELECT * FROM round;";
       return jdbc.query(sql, new RoundMapper());
    }

    @Override
    public List<Round> getRoundsForGame(int gameID) {
        final String sql = "SELECT * FROM round WHERE gameID = ?;";
        return jdbc.query(sql, new RoundMapper(), gameID);
    }

    @Override
    public Round findById(int id) {
        try {
            final String sql = "SELECT * FROM round WHERE id = ?;";
            return jdbc.queryForObject(sql, new RoundMapper(), id);
        } catch(DataAccessException e){
            return null;
        }
    }

    @Override
    public boolean update(Round round) {
        final String sql = "UPDATE round SET " +
                "guess = ?, " +
                "guessResults = ?, " +
                "time = ?, " +
                "gameID = ? " +
                "WHERE id = ?;";

        return jdbc.update(sql,
                round.getGuess(),
                round.getGuessResults(),
                round.getTime(),
                round.getGameID(),
                round.getId()) > 0;
    }

    @Override
    public boolean deleteById(int id) {
        final String sql = "DELETE FROM round WHERE id = ?;";
        return jdbc.update(sql, id)  > 0;
    }

    private static final class RoundMapper implements RowMapper<Round>{

        @Override
        public Round mapRow(ResultSet resultSet, int i) throws SQLException {
            Round r = new Round();
            r.setId(resultSet.getInt("id"));
            r.setGuess(resultSet.getString("guess"));
            r.setGuessResults(resultSet.getString("guessResults"));
            r.setTime(resultSet.getTimestamp("time"));
            r.setGameID(resultSet.getInt("gameID"));

            return r;
        }
    }
}
