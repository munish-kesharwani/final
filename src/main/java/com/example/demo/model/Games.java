package com.example.demo.model;

import java.util.List;

public class Games {
    public List<Game> gamelist;
    public String msgForUser;

    public List<Game> getGames() {
        return gamelist;
    }

    public void setGames(List<Game> games) {
        this.gamelist = games;
    }

    public String getMsgForUser() {
        return msgForUser;
    }

    public void setMsgForUser(String msgForUser) {
        this.msgForUser = msgForUser;
    }
}
