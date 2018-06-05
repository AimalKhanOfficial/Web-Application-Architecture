package main.entities;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private int teamKey;
    private String name;
    private String city;
    private String mascot;
    private List<Player> players;
    private String homeUniform;
    private String visitUniform;
    private List<Match> matchesAsHome;
    private List<Match> matchesAsVisitor;

    public Team(){
        players = new ArrayList<>();
        matchesAsHome = new ArrayList<>();
        matchesAsVisitor = new ArrayList<>();
    }

    public int getTeamKey() {
        return teamKey;
    }

    public void setTeamKey(int teamKey) {
        this.teamKey = teamKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMascot() {
        return mascot;
    }

    public void setMascot(String mascot) {
        this.mascot = mascot;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Player players) {
        this.players.add(players);
    }

    public String getHomeUniform() {
        return homeUniform;
    }

    public void setHomeUniform(String homeUniform) {
        this.homeUniform = homeUniform;
    }

    public String getVisitUniform() {
        return visitUniform;
    }

    public void setVisitUniform(String visitUniform) {
        this.visitUniform = visitUniform;
    }

    public List<Match> getMatchesAsHome() {
        return matchesAsHome;
    }

    public void setMatchesAsHome(List<Match> matchesAsHome) {
        this.matchesAsHome = matchesAsHome;
    }

    public List<Match> getMatchesAsVisitor() {
        return matchesAsVisitor;
    }

    public void setMatchesAsVisitor(List<Match> matchesAsVisitor) {
        this.matchesAsVisitor = matchesAsVisitor;
    }
}
