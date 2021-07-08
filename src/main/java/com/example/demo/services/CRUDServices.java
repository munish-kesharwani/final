package com.example.demo.services;

import com.example.demo.model.Game;
import com.example.demo.repository.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CRUDServices {
    public static final Logger logger = LoggerFactory.getLogger(CRUDServices.class);

    public CRUDServices() {
        super();
    }

    @Autowired
    GameRepository gameRepository;
public List<Game> getAllGames()
{
    List<Game> games = new ArrayList<Game>();
    gameRepository.findAll().forEach(game -> games.add(game));
    logger.info("In the method getAllGames");
    return games;
}

public Game getGameById(long id)
{
    logger.info("In the method getGameByID");
    return gameRepository.findById(id).get();

}

public void deleteGame (long id)
{
    logger.info("In the method deleteGame");
    gameRepository.deleteById(id);
}

public long createOrUpdate (Game game)
{
    logger.info("In the method to create of update");
    gameRepository.save(game);
    return game.getGameId();

}


}

