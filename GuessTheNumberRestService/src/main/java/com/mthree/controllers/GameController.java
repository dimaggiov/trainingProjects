package com.mthree.controllers;


import com.mthree.models.Game;
import com.mthree.models.Round;
import com.mthree.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public int begin() {
        return  service.addGame();
    }

    @PostMapping("/guess")
    public Round guess(@RequestBody Round round) {
        return service.guess(round);

    }

    @GetMapping
    public List<Game> getAll(){
        return service.getAllValidGames();
    }

    @GetMapping("/{gameId}")
    public Game getById(@PathVariable int gameId){
        return service.getGameById(gameId);
    }

    @GetMapping("/rounds/{gameId}")
    public List<Round> getRoundsForGame(@PathVariable int gameId){
        return service.getRoundsForGame(gameId);

    }




}
