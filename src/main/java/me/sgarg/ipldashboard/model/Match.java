package me.sgarg.ipldashboard.model;

import java.time.LocalDate;

public class Match {
    private long id;
    private String city;
    private LocalDate date;
    private String playerOfMatch;
    private String venue;
    private String team1;
    private String team2;
    private String tossWinner;
    private String tossDecision;
    private String winner;
    private String result;
    private String resultMargin;
    private String umpire1;
    private String umpire2;

    public long getId() {
        return id;
    }

    public Match setId(long id) {
        this.id = id;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Match setCity(String city) {
        this.city = city;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public Match setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public String getPlayerOfMatch() {
        return playerOfMatch;
    }

    public Match setPlayerOfMatch(String playerOfMatch) {
        this.playerOfMatch = playerOfMatch;
        return this;
    }

    public String getVenue() {
        return venue;
    }

    public Match setVenue(String venue) {
        this.venue = venue;
        return this;
    }

    public String getTeam1() {
        return team1;
    }

    public Match setTeam1(String team1) {
        this.team1 = team1;
        return this;
    }

    public String getTeam2() {
        return team2;
    }

    public Match setTeam2(String team2) {
        this.team2 = team2;
        return this;
    }

    public String getTossWinner() {
        return tossWinner;
    }

    public Match setTossWinner(String tossWinner) {
        this.tossWinner = tossWinner;
        return this;
    }

    public String getTossDecision() {
        return tossDecision;
    }

    public Match setTossDecision(String tossDecision) {
        this.tossDecision = tossDecision;
        return this;
    }

    public String getWinner() {
        return winner;
    }

    public Match setWinner(String winner) {
        this.winner = winner;
        return this;
    }

    public String getResult() {
        return result;
    }

    public Match setResult(String result) {
        this.result = result;
        return this;
    }

    public String getResultMargin() {
        return resultMargin;
    }

    public Match setResultMargin(String resultMargin) {
        this.resultMargin = resultMargin;
        return this;
    }

    public String getUmpire1() {
        return umpire1;
    }

    public Match setUmpire1(String umpire1) {
        this.umpire1 = umpire1;
        return this;
    }

    public String getUmpire2() {
        return umpire2;
    }

    public Match setUmpire2(String umpire2) {
        this.umpire2 = umpire2;
        return this;
    }
}
