package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Game {
    private String msgForUser;

    @Id
    @Column
    private long gameId;
    @Column
    private String gameStatus;
    @Column
    private String whoseTurnToPlay;

    @Column
    private String cell1;
    @Column
    private String cell2;
    @Column
    private String cell3;
    @Column
    private String cell4;
    @Column
    private String cell5;
    @Column
    private String cell6;
    @Column
    private String cell7;
    @Column
    private String cell8;
    @Column
    private String cell9;

    public Game(String msgForUser) {
        super();
        this.msgForUser=msgForUser;
    }

    public Game()
    {
        super();
    }

    public String getMsgForUser() {
        return msgForUser;
    }

    public void setMsgForUser(String msgForUser) {
        this.msgForUser = msgForUser;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    public String getWhoseTurnToPlay() {
        return whoseTurnToPlay;
    }

    public void setWhoseTurnToPlay(String whoseTurnToPlay) {
        this.whoseTurnToPlay = whoseTurnToPlay;
    }

    public String getCell1() {
        return cell1;
    }

    public void setCell1(String cell1) {
        this.cell1 = cell1;
    }

    public String getCell2() {
        return cell2;
    }

    public void setCell2(String cell2) {
        this.cell2 = cell2;
    }

    public String getCell3() {
        return cell3;
    }

    public void setCell3(String cell3) {
        this.cell3 = cell3;
    }

    public String getCell4() {
        return cell4;
    }

    public void setCell4(String cell4) {
        this.cell4 = cell4;
    }

    public String getCell5() {
        return cell5;
    }

    public void setCell5(String cell5) {
        this.cell5 = cell5;
    }

    public String getCell6() {
        return cell6;
    }

    public void setCell6(String cell6) {
        this.cell6 = cell6;
    }

    public String getCell7() {
        return cell7;
    }

    public void setCell7(String cell7) {
        this.cell7 = cell7;
    }

    public String getCell8() {
        return cell8;
    }

    public void setCell8(String cell8) {
        this.cell8 = cell8;
    }

    public String getCell9() {
        return cell9;
    }

    public void setCell9(String cell9) {
        this.cell9 = cell9;
    }
}
