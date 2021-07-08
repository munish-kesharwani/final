package com.example.demo.controller;

import com.example.demo.model.Game;
import com.example.demo.services.CRUDServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {
    public static final Logger logger = LoggerFactory.getLogger(GameController.class);
    private CRUDServices services;
    @Autowired
    public GameController(CRUDServices services) {
        super();
        this.services=services;
    }

    @GetMapping("/games")
    private List<Game> getAllGames()
    {
        return services.getAllGames();
    }

    @GetMapping("/games/{id}")
    private Game getGameById(@PathVariable("id") long id)
    {
        return services.getGameById(id);
    }

    @PostMapping("/games")
    private long saveGame(@RequestBody Game game)
    {
        return services.createOrUpdate(game);
    }

    @DeleteMapping("/games/{id}")
    private void deleteGameById(@PathVariable("id") long id)
    {
        services.deleteGame(id);
    }
}
