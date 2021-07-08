package com.example.demo.controller;

import com.example.demo.model.Game;
import com.example.demo.model.Games;
import com.example.demo.services.WebCRUDServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class WebCRUDController {
    public static Logger logger = LoggerFactory.getLogger(WebCRUDController.class);
    private WebCRUDServices service;

    public WebCRUDController() {
        super();
    }

    @Autowired
    public WebCRUDController(WebCRUDServices service) {
        super();
        this.service = service;
    }

    @GetMapping("/web")
    public String displayAllGames(Model aModel)
    {
        logger.info("Int the method displayAllGames");
        aModel.addAttribute("games",service.getAllGamesWeb());
        return "web";
    }

    @PostMapping("/web")
    public String processInput(@RequestParam(value = "id" , required = false) long[] ids, Model pOutput, @RequestParam(value="action", required=true) String action)
    {
        logger.info("In the method processInput");

        StringBuffer sb = new StringBuffer();
        if (ids != null )
        for (int i=0;i<ids.length;i++) sb.append(":"+ids[i]+":");
        logger.info("Input: " + sb );
        logger.info("action received is : "+ action);
        if ("Delete".equalsIgnoreCase(action)) {
            service.deleteGames(ids);
            Games games = service.getAllGamesWeb();
            games.setMsgForUser("Games " + sb + "have been deleted!");
            pOutput.addAttribute("games",games);
            return "web";
        }
        else
        {

            Game game;
            if ("Update".equalsIgnoreCase(action) ) {
                game= service.getGame(ids[0]);
                game.setMsgForUser("Please update Game [" + ids[0] + ":");
            }
            else {
                game = new Game();
                game.setMsgForUser("Please create new Game");
            }

            pOutput.addAttribute("game",game);
            return "edit";
        }
    }

    @PostMapping("/post")
    public String createOrUpdate (@ModelAttribute Game game, Model pOutput)
    {
        logger.info("In the method createOrUpdate");
        logger.info("saving game with Id:"+game.getGameId()+":and status:"+game.getGameStatus());
        service.saveGame(game);
        Games games = service.getAllGamesWeb();
        games.setMsgForUser("Game :"+game.getGameId()+": has been saved!");
        pOutput.addAttribute("games",games);
        return "web";
    }

    public WebCRUDServices getService() {
        return service;
    }

    public void setService(WebCRUDServices service) {
        this.service = service;
    }
}
