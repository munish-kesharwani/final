package com.example.demo.services;

import com.example.demo.model.Game;
import com.example.demo.model.Games;
import com.example.demo.repository.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WebCRUDServices {

    public static final Logger logger = LoggerFactory.getLogger(WebCRUDServices.class);

    @Autowired
    GameRepository gameRepository;
    public WebCRUDServices() {
        super();

    }

    public Games getAllGamesWeb()
    {
        logger.info("In the method GetAllGamesForWeb");
        List<Game> games = new ArrayList<Game>();
        gameRepository.findAll().forEach(game -> games.add(game));

       Games gamelist = new Games();
       gamelist.setMsgForUser("Please use form for CRUD operations");
       gamelist.setGames(games);
        return gamelist;
    }

    public void deleteGames(long [] ids)
    {
        for (int i =0; i<ids.length;i++)
        gameRepository.deleteById(ids[i]);


    }

    public void saveGame(Game game)
    {
        gameRepository.save(game);
    }

    public Game getGame(long id)
    {
        return gameRepository.findById(id).get();
    }
}
