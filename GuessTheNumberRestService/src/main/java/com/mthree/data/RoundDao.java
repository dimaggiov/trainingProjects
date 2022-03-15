package com.mthree.data;

import com.mthree.models.Round;

import java.util.List;

public interface RoundDao {

    Round addRound(Round round);

    List<Round> getAllRounds();

    List<Round> getRoundsForGame(int gameID);

    Round findById(int id);

    boolean update(Round round);

    boolean deleteById(int id);
}
